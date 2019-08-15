package lectures.part2oop

object InheritanceAndTraits extends App {

  class Animal {
    protected def eat(): Unit = println("animal eating")
  }

  class Cat extends Animal {
    def crunch(): Unit = {
      eat()
      println("cat eating")
    }
  }

  val cat = new Cat
//  println(cat.crunch())

  class Person(name: String, age: Int) {
    def this(name: String) = this(name, 0)
  }
  class Adult(name: String, age: Int, idCard: String) extends Person(name)

  class Dog extends Animal {
    override def eat(): Unit = println("dog eating")
    def test(): Unit = {}
  }

  val dog = new Dog()
  println(dog.eat())
  println(dog.test())

}
