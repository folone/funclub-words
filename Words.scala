import scala.io.Source
// Using scalaz a-la-carte imports to not polute the namespace
import scalaz._
import std.function._
import std.map._
import std.anyVal._
import syntax.arrow._
import syntax.show._
import syntax.monoid._
import effect._
import IO._

object Words {
  val N = 10
  // :: Char → Boolean
  def acceptedChars(c: Char) = {
    // We could, of course, do
    // c.isLetterOrDigit || c.isWhitespace || c == '-'
    // But that would have been boring.
    // How about some Arrows?
    val sum: (((Boolean, Boolean), Boolean)) ⇒ Boolean = _ match {
      case ((a, b), c) ⇒ a || b || c
    }
    val fun = ((_: Char).isLetterOrDigit) &&&
              ((_: Char).isWhitespace)    &&&
              ((_: Char) == '-')
    (fun >>> sum)(c)
  }

  // Show typeclass instance
  // instance Show List (String, Int) where
  implicit val mapInstances = new Show[List[(String, Int)]] with Monoid[List[(String, Int)]] {
    override def zero = Nil
    def append(f1: List[(String, Int)],f2: ⇒ List[(String, Int)]): List[(String, Int)] =
      (f1.toMap |+| f2.toMap).toList
    override def shows(l: List[(String, Int)]) =
      l.foldLeft("") { case(acc, (key, value)) ⇒
          acc + "\n" + key + ": " + value
      }
  }

  // :: String → List (String, Int)
  def wordCount(text: String): List[(String, Int)] =
        // Leave letters, digits and spaces
    text.filter(acceptedChars)
        // split words
        .toLowerCase.split("\\W")
        // Optionally parallelize
        .par
        // group
        .groupBy(identity)
        // calculate group sizes
        .map { case(key, value) ⇒ key.trim → value.length }
        // deal with several spaces between words
        .filterNot { case(key, _) ⇒ key.isEmpty}
        // sort descending
        .toList.sortBy { case(_, value) ⇒ -value }
        // Get results from parallel computation
        .seq.toList

  def wholeFile(path: String) =
    for {
      source ← IO { Source.fromFile(path) }
      text   = source.mkString
      _      ← IO { source.close() }
      result = wordCount(text)
    } yield result.take(N).shows

  def byLine(path: String) =
    for {
      source ← IO { Source.fromFile(path) }
      stream = source.getLines.toStream
      result = stream.map(wordCount)
                     .foldLeft(Nil: List[(String, Int)]) { case(acc, v) ⇒
                       acc |+| v
                     }.sortBy { case(_, value) ⇒ -value }
      _      ← IO { source.close() }
    } yield result.take(N).shows

  // :: Array String → ()
  def main(args: Array[String]) = {
    val path   = args(0)
    val action = for {
      lines ← time(byLine(path))
      full  ← time(wholeFile(path))
      _     ← putStrLn("By lines: " + lines)
      _     ← putStrLn("Whole: " + full)
    } yield ()
    // Yuck!
    action.unsafePerformIO()
  }

  // Profiling function
  def time[R](block: ⇒ IO[R]): IO[R] =
    for {
      t0     ← IO { System.nanoTime() }
      result ← block
      t1     ← IO { System.nanoTime() }
      _      ← putStrLn("Elapsed time: " + (t1 - t0) + " ns")
    } yield result
}
