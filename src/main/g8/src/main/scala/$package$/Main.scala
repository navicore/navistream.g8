package $package$

import akka.actor.ActorSystem
import akka.stream.{ActorMaterializer, ActorMaterializerSettings}
import akka.stream.scaladsl.Source
import scala.concurrent.duration._

object Main extends App {

  implicit val actorSystem: ActorSystem = ActorSystem("example")
  implicit val materializer: ActorMaterializer = ActorMaterializer(
    ActorMaterializerSettings(actorSystem))

  val src = Source.fromGraph(new $name;format="Camel"$Sink()).throttle(1, 1.seconds)

  val sink = new $name;format="Camel"$()

  src.runWith(sink)

}
