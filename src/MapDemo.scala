
// https://www.scala-lang.org/files/archive/api/2.13.0-M4/scala/collection/immutable/ChampHashMap.html
// https://michael.steindorfer.name/publications/oopsla15.pdf
object MapDemo extends App {

  def mask(hash: Int, shift: Int): Int = {
    return (hash >> shift) & Integer.parseInt("11111", 2);
  }

  def index(bitmap: Int, bitpos: Int): Int = {
    return Integer.bitCount(bitmap & (bitpos - 1));
  }

  // assume value is hash
  val map = Map("A" -> 17, "B" -> 16);
  val shift = 0;

  // https://commitlogs.com/2016/09/10/scala-fold-foldleft-and-foldright/
  val bitmap = map.values.fold(0) {
    (a, b) =>
      val bitPos = 1 << mask(b, shift);
      a | bitPos;
  };

  val indexMap = map.mapValues { hash =>
    val bitPos = 1 << mask(hash, shift);
    val i = index(bitmap, bitPos);
    i;
  };

  println(indexMap) // Map(A -> 1, B -> 0)

}
