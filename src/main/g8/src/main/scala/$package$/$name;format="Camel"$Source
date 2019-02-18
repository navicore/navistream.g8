package $package$

import akka.stream.{Attributes, Outlet, SourceShape}
import akka.stream.stage.{GraphStage, GraphStageLogic, OutHandler}
import com.typesafe.scalalogging.LazyLogging

class $name;format="Camel"$Source extends GraphStage[SourceShape[(String, Long)]] with LazyLogging {

  val out: Outlet[(String, Long)] = Outlet[(String, Long)]("MySource")

  override val shape: SourceShape[(String, Long)] = SourceShape(out)

  override def createLogic(inheritedAttributes: Attributes): GraphStageLogic = {

    new GraphStageLogic(shape) {

      setHandler(
        out,
        new OutHandler {

          var count: Long = 0 // state used to simulate unbounded input source

          override def onPull(): Unit = {
            //
            // put your input code here
            //
            count += 1
            push(out, ("haha", count))
          }

        })

      override def preStart(): Unit = {
        logger.info("starting source")
        super.preStart()
      }
    }
  }

}
