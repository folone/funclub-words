package info.folone.words

import com.clarifi.machines._

import scalaz.{Reader ⇒ _, _}
import scalaz.effect._
import IO._
import Scalaz._

import scala.language.postfixOps

import java.io._

object WordMachine {

  import Machine.ProcessCategory._
  import Plan._

  def getFileLines[A](f: File, m: Process[String, A]): Procedure[IO, A] =
    new Procedure[IO, A] {
      type K = String ⇒ Any
      val machine = m
      def withDriver[R](k: Driver[IO, K] ⇒ IO[R]): IO[R] = {
        bufferFile(f).bracket(close)(r ⇒ {
          val d = new Driver[IO, String ⇒ Any] {
            val M = Monad[IO]
            def apply(k: String ⇒ Any) = rReadLn(r) map (_ map k)
          }
          k(d)
        })
      }
    }

  def bufferFile(f: File): IO[BufferedReader] =
    IO { new BufferedReader(new FileReader(f)) }

  /** Read a line from a buffered reader */
  def rReadLn(r: BufferedReader): IO[Option[String]] =
    IO { Option(r.readLine) }

  // Begin the fast version
  val words: Process[String, String] = (for {
    s ← await[String]
    _ ← traversePlan_(s.toLowerCase.split("\\W").toList)(emit)
  } yield ()) repeatedly

  def wc(path: String) =
    getFileLines(new File(path),
      (id split words) outmap (_.fold(l ⇒ (1, Map.empty[String, Int]),
                                      w ⇒ (0, Map(w → 1))))) execute
  // End fast version

  def wordFreq(path: String) =
    getFileLines(new File(path),
      id outmap wordCount) execute

  def mainIO(path: String) = {
    val actionWF = for {
      _      ← putStrLn("Using the wordCount function")
      wordFq ← time(wordFreq(path))
      _      ← putStrLn(wordFq.toList.shows)
    } yield ()
    val actionWC = for {
      _           ← putStrLn("Using the wc Procedure.")
      (_, wordFq) ← time(wc(path))
      _           ← putStrLn(wordFq.toList.shows)
    } yield ()
    actionWC |+| actionWF
  }

  def main(args: Array[String]) = {
    val path   = args(0)
    mainIO(path).unsafePerformIO()
  }
}

