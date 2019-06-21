package lectures.part1basics

object StringOps extends App {
  val str: String = "Hello, I am learning scala"

  //From Java
  println(str.charAt(2))
  println(str.substring(7, 11))
  println(str.split(" ").toList)
  println(str.startsWith("Hello"))
  println(str.replace(" ", "-"))
  println(str.toLowerCase())
  println(str.length)

  //Built in scala
  val aString: String = "45"
  val aNumber: Int = aString.toInt
  println('a' +: aString :+ 'z')
  println(str.reverse)
  println(str.take(5))

  //String Interpolation
  val name = "hitalo"
  val age = 29
  val greeting = s"Hello I'm $name and I am $age years old"
  val greetingOp = s"Hello I'm $name and I am ${age + 1 - 1} years old"
  println(greeting)
  println(greetingOp)

  //Format Interpolations
  val speed = 14.2f
  val myth = f"$name can run $speed%05.9fkm/h"
  println(myth)

  //Raw interpolation
  println(raw"this is a \n newline")
  val escaped = "this is a \n newline"
  println(raw"$escaped")


}
