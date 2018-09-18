
// https://stackoverflow.com/questions/6051302/what-does-colon-underscore-star-do-in-scala
object RepeatedParameters extends App {
  val x: Seq[Seq[Int]] = Seq(Seq(1), Seq(2))

  def f(arg: Seq[Any]*): Int = {
    arg.length
  }

  println(f(x)) //1 as x is taken as single arg
  println(f(x: _*)) // 2 as x is "unpacked" as a Seq[Any]*
}