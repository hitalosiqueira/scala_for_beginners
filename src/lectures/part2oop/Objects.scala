package lectures.part2oop

object Objects extends App {

  // "static"
  // Singleton instance
  // Objects does not take parameters
  object Person {
    val N_EYES = 2
    def canFly: Boolean = false
    def apply(name: String): Person = new Person(name)
  }

  //instance
  class Person(val name: String) {

  }

  //combined, class and objects are COMPANIONS

  val mary = new Person("Mary")
  val john = new Person("John")

  println(mary == john)

  val hitalo = Person("Hitalo")

  println(hitalo.name)
}
