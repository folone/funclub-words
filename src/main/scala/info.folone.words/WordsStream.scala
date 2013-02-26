package info.folone.words

import scala.io.Source
// Using scalaz a-la-carte imports to not polute the namespace
import scalaz._
import syntax.show._
import syntax.monoid._
import effect._
import IO._

object WordsStream {
  def byLine(path: String) =
    for {
      source ← IO { Source.fromFile(path) }
      stream = source.getLines.toStream
      result = stream.map(wordCount)
                     .foldLeft(Nil: List[(String, Int)]) { case(acc, v) ⇒
                       acc |+| v
                     }.sortBy { case(_, value) ⇒ value }
      _      ← IO { source.close() }
    } yield result.shows

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
