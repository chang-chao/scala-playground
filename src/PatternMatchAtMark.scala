
// https://stackoverflow.com/questions/4513380/scala-match-help
object PatternMatchAtMark extends App {
  val something = List(1, 2, 3)
  something match {
    case ls @ List(_, elem, _) =>
      println("matching:" + ls); elem
    case _ => println("not found")
  }
}