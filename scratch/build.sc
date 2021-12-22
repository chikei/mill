import mill._
import mill.scalalib._

object foo extends ScalaModule{
  def scalaVersion = "2.13.2"

  object test extends Tests with TestModule.Utest
}

object bar extends ScalaModule{
  def scalaVersion = "2.13.2"
}

class FooModule(crossVersion: String) extends ScalaModule {
  def scalaVersion = crossVersion

  object test extends Tests with TestModule.Utest
}

object c extends mill.Cross[FooModule]("2.10", "2.11", "2.12")
