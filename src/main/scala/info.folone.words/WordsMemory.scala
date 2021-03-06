package info.folone.words

import scala.io.Source
// Using scalaz a-la-carte imports to not polute the namespace
import scalaz._
import syntax.show._
import effect._
import IO._

object WordsMemory {
  def wholeFile(path: String): IO[String] =
    IO { Source.fromFile(path) }.bracket(close) { source ⇒
      IO {
        val text   = source.mkString
        val result = wordCount(text)
        result.toList.shows
      }
    }

  def mainIO(path: String) =
    for {
      _      ← putStrLn("In memory")
      full   ← time(wholeFile(path))
      _      ← putStrLn(full)
    } yield ()

  // :: Array String → ()
  def main(args: Array[String]) = {
    val path   = args(0)
    // Yuck!
    mainIO(path).unsafePerformIO()
  }
}
