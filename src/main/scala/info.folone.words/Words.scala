package info.folone.words

import scala.io.Source
// Using scalaz a-la-carte imports to not polute the namespace
import scalaz._
import syntax.show._
import syntax.monoid._
import effect._
import IO._

object Words {
  // :: String → List (String, Int)
  def wordCount(text: String): List[(String, Int)] =
    splitWords(text)
        .par
        // group
        .groupBy(identity)
        // calculate group sizes
        .map { case(key, value) ⇒ key.trim → -value.length }
        // Get results from parallel computation
        .seq.toList

  def wholeFile(path: String) =
    for {
      source ← IO { Source.fromFile(path) }
      text   = source.mkString
      _      ← IO { source.close() }
      result = wordCount(text)
    } yield result.shows

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
      _      ← putStrLn("By lines: " + lines)
      full   ← time(wholeFile(path))
      _      ← putStrLn("Whole: " + full)
    } yield ()
    // Yuck!
    action.unsafePerformIO()
  }
}
