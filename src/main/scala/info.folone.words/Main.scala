package info.folone.words

import scalaz._, Scalaz._

object Main {
  def main(args: Array[String]) {
    val path     = args(0)
    val actions  = List(WordsMemory.mainIO _, WordsStream.mainIO _, WordMachine.mainIO _)
    val action   = actions.suml // use the Monoid instance, foldl(IO())(_ |+| _)
    val results  = actions.traverse(f ⇒ f(path)) // Use the Applicative instance (sequence . map)
    val results2 = for {
      _ ← WordsMemory.mainIO(path)
      _ ← WordsStream.mainIO(path)
      _ ← WordMachine.mainIO(path)
    } yield () // Use the Monad instance
    // Yuck!
    action(path).unsafePerformIO()
    //results.unsafePerformIO()
    //results2.unsafePerformIO()
  }
}
