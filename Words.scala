import scala.io.Source
// Using scalaz a-la-carte imports to not polute the namespace
import scalaz._
import std.function._
import syntax.arrow._
import syntax.show._
import effect._
import IO._

object Words {
  // :: Char → Boolean
  def acceptedChars(c: Char) = {
    // We could, of course, do
    //c.isLetterOrDigit || c.isWhitespace || c == '-'
    // But that would have been boring.
    // How about some Arrows?
    val fun = ((c: Char) ⇒ c.isLetterOrDigit) &&&
              ((c: Char) ⇒ c.isWhitespace)    &&&
              ((c: Char) ⇒ c == '-')
    fun(c) match {
      case((a, b), c) ⇒ a || b || c
    }
  }

  // Show typeclass instance
  // instance Show List (String, Int) where
  implicit val mapShow = new Show[List[(String, Int)]] {
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
        .toList
        .sortBy { case(_, value) ⇒ -value }
        // take the largest 10
        .take(10)
        // Get results from parallel computation
        .seq.toList

  // :: String → IO String
  def getFileContent(path: String) = IO {
    val source  = Source.fromFile(path)
    val content = source.mkString
    source.close()
    content
  }

  // :: Array String → ()
  def main(args: Array[String]) = {
    val path   = args(0)
    val action = for {
      text   ← getFileContent(path)
      // Don't need timing? Just do:
      // result = wordCount(text)
      result ← time(wordCount(text))
      _      ← putStrLn(result.shows)
    } yield ()
    // Yuck!
    action.unsafePerformIO()
  }

  // Profiling function
  def time[R](block: ⇒ R): IO[R] =
    for {
      t0     ← IO { System.nanoTime() }
      result = block
      t1     ← IO { System.nanoTime() }
      _      ← putStrLn("Elapsed time: " + (t1 - t0) + " ns")
    } yield result
}
