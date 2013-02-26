package info.folone.words

import scala.io.Source
// Using scalaz a-la-carte imports to not polute the namespace
import scalaz._
import std.map._
import std.anyVal._
import syntax.show._
import syntax.monoid._
import effect._
import IO._

object WordsStream {
  def byLine(path: String): IO[String] =
    IO { Source.fromFile(path) }.bracket(close) { source ⇒
      IO {
        val stream = source.getLines.toStream
        val result = stream.map(wordCount)
          .foldLeft(Map.empty[String, Int]) { case(acc, v) ⇒
            acc |+| v
        }.toList.sortBy { case(_, value) ⇒ value }
        result.shows
      }
    }

  // :: Array String → ()
  def main(args: Array[String]) = {
    val path   = args(0)
    val action = for {
      lines  ← time(byLine(path))
      _      ← putStrLn(lines)
    } yield ()
    // Yuck!
    action.unsafePerformIO()
  }
}
