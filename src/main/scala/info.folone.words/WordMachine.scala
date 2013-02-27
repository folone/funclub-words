package info.folone.words

import com.clarifi.machines._

import scalaz.{Reader ⇒ _, _}
import scalaz.effect._
import IO._
import Scalaz._

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

  def wordFreq(path: String) =
    getFileLines(new File(path),
      id outmap wordCount) execute

  def main(args: Array[String]) = {
    val path = args(0)
    val action = for {
      wordFreqs ← time(wordFreq(path))
      _         ← putStrLn(wordFreqs.toList.shows)
    } yield ()
    action.unsafePerformIO()
  }
}

