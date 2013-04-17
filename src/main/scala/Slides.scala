import scalaz._, Scalaz._
import Free.Trampoline, Trampoline._

object Slides {
  def even(n: Int): Boolean =
    if (n == 0) true
    else odd(n - 1)
  def odd(n: Int): Boolean =
    if (n == 0) false
    else even(n - 1)

  def evenTr(n: Int): Trampoline[Boolean] =
    if (n == 0) done(true)
    else suspend(oddTr(n - 1))
  def oddTr(n: Int): Trampoline[Boolean] =
    if (n == 0) done(false)
    else suspend(evenTr(n - 1))

  def fibRec(n: Int): Int =
    if (n < 2) n else fibRec(n - 1) + fibRec(n - 2)
  def fibTailrec(n: Int) = {
    def loop(n: Int, next: Int, result: Int): Int = n match {
      case 0 => result
      case _ => loop(n - 1, next + result, next)
    }
    loop(n, 1, 0)
  }
  def fibTramp(n: Int): Trampoline[Int] =
    if (n < 2) done(n) else suspend {
      for {
        i <- fibTramp(n - 1)
        j <- fibTramp(n - 2)
      } yield i + j
    }

  import scalaz.scalacheck.ScalazProperties._
  def checkInt    = semigroup.laws[Int].check
  def checkStr    = monoid.laws[String].check
  def checkDouble = monoid.laws[Double].check // Fails
}
