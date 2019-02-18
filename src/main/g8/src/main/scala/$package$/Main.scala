package $package$

import akka.actor.ActorSystem
import akka.stream.{ActorMaterializer, ActorMaterializerSettings}
import akka.stream.scaladsl.Source
import scala.concurrent.duration._

object Main extends App {

  implicit val actorSystem: ActorSystem = ActorSystem("$name;format="Camel"$System")
  implicit val materializer: ActorMaterializer = ActorMaterializer(
    ActorMaterializerSettings(actorSystem))

  val src = Source.fromGraph(new $name;format="Camel"$Source()).throttle(1, 1.seconds)

  val sink = new $name;format="Camel"$Sink()

  src.runWith(sink)

}
