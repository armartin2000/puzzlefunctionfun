package recursionfun

/**
  * Created by amartinez on 7/5/16.
  */
object DiamondObject {
  def main(args: Array[String]) {
    println("Printing Diamond: <width=12>")
    renderNWideDiamond(12)
  }

  def renderNWideDiamond(n: Int) {
    def printFormattedDiamondCharSeq(num: Int): Unit = {
      def pad(n: Int): Unit = {
        for (k <- 1 to n) print(" ")
      }
      def stars(n: Int): Unit = {
        for (k <- 1 to n) print("*")
      }
      val padding: Int = (n - num) / 2
      pad(padding)
      stars(num)
      pad(padding)
      println("")
    }
    def loop(f: Int => Int, loops: Int, numChars: Int): Unit = {
      if (loops > 0) {
        printFormattedDiamondCharSeq(numChars)
        loop(f, loops - 2, f(numChars))
      }
    }
    val startValue = if (n % 2 == 0) 2 else 1
    loop(x => x + 2, n, startValue)
    loop(x => x - 2, n - 2, n - 2)
  }
}
