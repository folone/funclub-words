package info.folone.words

import scalaz._, Scalaz._

object Main {
  def main(args: Array[String]) {
    val path = args(0)
    val action = WordsMemory.mainIO(path) |+|
                 WordsStream.mainIO(path) |+|
                 WordMachine.mainIO(path)
    // Yuck!
    action.unsafePerformIO()
  }
}
