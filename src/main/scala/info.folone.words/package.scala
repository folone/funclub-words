package info.folone

import scalaz._
import std.map._
import std.anyVal._
import std.function._
import syntax.arrow._
import syntax.monoid._
import effect._
import IO._

package object words {
  val N = 10
  // Show and Monoid typeclasses instance
  // instance Show List (String, Int) where
  implicit val mapInstances = new Show[List[(String, Int)]] with Monoid[List[(String, Int)]] {
    override def zero = Nil
    def append(f1: List[(String, Int)], f2: ⇒ List[(String, Int)]): List[(String, Int)] =
      (f1.toMap |+| f2.toMap).toList
    override def shows(l: List[(String, Int)]) =
      l.filterNot(_._1.isEmpty).sortBy(_._2).take(N).foldLeft("") { case(acc, (key, value)) ⇒
          acc + "\n" + key + ": " + (-value)
      }
  }

  // :: Char → Boolean
  def acceptedChars(c: Char) = {
    // We could, of course, do
    // c.isLetterOrDigit || c.isWhitespace || c == '-'
    // But that would have been boring.
    // How about some Arrows? (http://haskell.org/arrows/)?
    val sum: (((Boolean, Boolean), Boolean)) ⇒ Boolean = _ match {
      case ((a, b), c) ⇒ a || b || c
    }
    val fun = ((_: Char).isLetterOrDigit) &&&
              ((_: Char).isWhitespace)    &&&
              ((_: Char) == '-')
    (fun >>> sum)(c)
  }

  def splitWords(text: String): List[String] =
    text.filter(acceptedChars)
       // split words
       .toLowerCase.split("\\W").toList

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

  // Profiling function
  def time[R](block: ⇒ IO[R]): IO[R] =
    for {
      t0     ← IO { System.nanoTime() }
      result ← block
      t1     ← IO { System.nanoTime() }
      _      ← putStrLn("Elapsed time: " + (t1 - t0) + " ns")
    } yield result

  def close(r: {def close(): Unit}) = IO { r.close() }
}
