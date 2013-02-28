package info.folone.words

import scalaz._, Scalaz._

object Main {
  def main(args: Array[String]) {
    val path = args(0)
    val action = WordsMemory.mainIO _ |+|
                 WordsStream.mainIO _ |+|
                 WordMachine.mainIO _
    // Yuck!
    action(path).unsafePerformIO()
  }
}
