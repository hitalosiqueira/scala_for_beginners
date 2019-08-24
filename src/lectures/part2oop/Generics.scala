package lectures.part2oop

object Generics extends App{

  class MyList[+A] {
    def add[B >: A] (elem: B): MyList[B] = ???
    //in a list of cats, which is an animal, if i add a dog, which is also an animal
    //the list should return not a list of cats, but a list of animals instead
  }

  class MyMap[Key, Value] {

  }

  val listOfIntegers = new MyList[Integer]
  val listOfStrings = new MyList[String]

  object MyList {
    def empty[A]: MyList[A] = ???
  }

  val emptyListOfIntegers = MyList.empty[Int]

  //variance problem

  class Animal
  class Cat extends Animal
  class Dog extends Animal

  // 1. List[Cat] extends List[Animal]
  class CovariantList[+A]
  val animal: Animal = new Cat
  val animalList: CovariantList[Animal] = new CovariantList[Cat]


  // 2. List[A] do not extends the super class
  class InvariantList[A]
//  val invariantList: InvariantList[Animal] = new InvariantList[Cat] //not allowed


  // 3. List[A] accepts a the super class to me assigned to the sub-type
  class ContraVariant[-A]
  val covariantList: ContraVariant[Cat] = new ContraVariant[Animal]


  // bounded type
  // cage only accepts sub-types of animal
  class Cage[A <: Animal](animal: A)
  val cage = new Cage(new Dog)


}
