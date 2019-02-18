package $package$

import akka.stream.{Attributes, Inlet, SinkShape}
import akka.stream.stage.{AbstractInHandler, GraphStage, GraphStageLogic}
import com.typesafe.scalalogging.LazyLogging

class $name;format="Camel"$Sink extends GraphStage[SinkShape[(String, Long)]] with LazyLogging {

  val in: Inlet[(String, Long)] = Inlet.create("MySink.in")
  override def shape(): SinkShape[(String, Long)] = SinkShape.of(in)

  override def createLogic(inheritedAttributes: Attributes): GraphStageLogic = {

    new GraphStageLogic(shape()) {

      setHandler(
        in,
        new AbstractInHandler {

          var count: Long = 0 // experimental counter for logging

          override def onPush(): Unit = {

            val element = grab(in)

            //
            // put your output code here
            //
            println(element)

            pull(in)

          }

        }
      )

      override def preStart(): Unit = {
        logger.info("starting sink")
        pull(in)
        super.preStart()
      }

    }

  }


}
