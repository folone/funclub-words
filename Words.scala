import scala.io.Source
// Using scalaz a-la-carte imports to not polute the namespace
import scalaz._
import syntax.show._
import effect._
import IO._

object Words {
  // :: Char → Boolean
  def letterOrDigitOrWhitespace(c: Char) = c.isLetterOrDigit || c.isWhitespace

  // Show typeclass instance
  // instance Show List (String, Int) where
  implicit val mapShow = new Show[List[(String, Int)]] {
    override def shows(l: List[(String, Int)]) = l.foldLeft("") { case(acc, (key, value)) ⇒
        acc + "\n" + key + ": " + value
    }
  }

  // :: String → List (String, Int)
  def wordCount(text: String): List[(String, Int)] =
        // Leave letters, digits and spaces
    text.filter(letterOrDigitOrWhitespace)
        // split words
        .toLowerCase.split("\\W")
        // Oprionally parallelize
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
        // Unparallelize
        .seq.toList

  // :: String → IO String
  def getFileContent(path: String) = IO {
    val source = Source.fromFile(path)
    val content = source.mkString
    source.close()
    content
  }

  // :: Array String → ()
  def main(args: Array[String]) = {
    val path = args(0)
    val action = for {
      text ← getFileContent(path)
      result ← time(wordCount(text))
      _ ← putStrLn(result.shows)
    } yield ()
    // Yuck!
    action.unsafePerformIO()
  }

  // Profiling function
  def time[R](block: ⇒ R): IO[R] =
    for {
      t0 ← IO { System.nanoTime() }
      result = block
      t1 ← IO { System.nanoTime() }
      _ ← putStrLn("Elapsed time: " + (t1 - t0) + " ns")
    } yield result
}
