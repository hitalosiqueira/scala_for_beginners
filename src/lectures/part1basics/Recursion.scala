package lectures.part1basics

object Recursion extends App {

  //Tail recursion
  def fact(n: Int, acc: BigInt = 1): BigInt = {
    if (n <= 1) acc
    else fact(n - 1, n * acc)
  }

  //Normal recursion
  def factorial(n: Int): Int = {
    if (n == 1) 1
    else n * factorial(n - 1)
  }

  //println(fact(100))

  def concat(name: String, n: Int, acc: String = ""): String = {
    if (n <= 1) acc + name
    else concat(name, n - 1, name + acc)
  }

  println(concat("hitalo", 3))

  def isPrime(n: Int): Boolean = {
    def isPrimeHelper(t: Int, acc: Boolean = true): Boolean = {
      if (!acc) false
      else if (t <= 1) true
      else isPrimeHelper(t - 1, n % t != 0 && acc)
    }
    isPrimeHelper(n / 2)
  }

  println(isPrime(13))
  println(isPrime(10))

  def fib(n: Int): Int = {
    def fibTailRec(i: Int, prev: Int, current: Int): Int = {
      if (i <= 0) current
      else fibTailRec(i - 1, prev = prev + current, current = prev)
    }

    fibTailRec(n, prev = 1, current = 0)
  }

  println(fib(10))
}
