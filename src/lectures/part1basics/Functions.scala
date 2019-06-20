package lectures.part1basics

object Functions extends App {

  def aFunction(a: String, b: Int): String = {
    a + " " + b
  }

  println(aFunction("hello", 3))

  def aParameterlessFunction(): Int = 42
  println(aParameterlessFunction())

  def aLoopFunction(aString: String, n: Int): String = {
    if (n == 1)
      aString
    else
      aString + aLoopFunction(aString, n - 1)
  }

  println(aLoopFunction("hello", 3))

  //When loops are needed, best to use recursion

  def greeting(name: String, age: Int): String = s"Hi, my name is $name and I am $age years old!"

  def factorial(n: Int): Int = {
    if (n == 1) 1
    else n * factorial(n - 1)
  }

  println(factorial(5))

  def fib(n: Int): Int = {
    if (n <= 2) 1
    else fib(n - 1) + fib (n - 2)
  }

  println(fib(10))

  def isPrime(n: Int): Boolean = {
    def isPrimeUntil(t: Int): Boolean = {
      if (t <= 1) true
      else n % t != 0 && isPrimeUntil(t - 1)
    }
    isPrimeUntil(n / 2)
  }

  println(isPrime(13))
  println(isPrime(10))
}
