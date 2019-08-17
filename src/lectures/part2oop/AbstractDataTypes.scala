package lectures.part2oop

object AbstractDataTypes extends App{
  abstract class Animal {
    val creatureType: String = "wild"
    def eat(): Unit
  }

  class Dog extends Animal {
    override val creatureType: String = "Canine"
    override def eat(): Unit = println("dog eating")
  }

  trait Carnivore {
    def eat(animal: Animal): Unit
  }

  class Crocodile extends Animal with Carnivore {
    override val creatureType: String = "crocodile"

    override def eat(): Unit = println("crocodile eating")

    override def eat(animal: Animal): Unit = println(s"I'm a $creatureType and I'm eating a ${animal.creatureType}")
  }

  val dog = new Dog
  val croc = new Crocodile
  croc.eat(dog)

  // traits vs abstract classes
  // trais do not have constructor parameters
  // muliple traits can be implemented but only one class can be inherited
  // traits means behavior (traits are the equivalent to interface in java)
}
