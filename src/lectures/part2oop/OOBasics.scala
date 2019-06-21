package lectures.part2oop

object OOBasics extends App {
  val person = new Person("hitalo", 29)
  println(person.name)

  val author = new Writer("Charles", "Dickens", 1812)
  val novel = new Book("Great Expectations", 1861, author)
  println(novel.authorAgeAt)
  println(novel.isWrittenBy(author))
}

//constructor
class Person(val name: String, val age: Int = 0) {

  //method overloading
  def greet(name: String): Unit = println(s"${this.name} says: Hi, $name")
  def greet(): Unit = println("Hey y'all!")

  //constructor overloading
  def this(name: String) = this(name, 0)
}

class Writer(val name: String, val surname: String, val year: Int) {

  def fullName: String = s"${this.name} ${this.surname}"

}

class Book(val name: String, year: Int, val author: Writer) {

  def authorAgeAt: Int = this.year - author.year
  def isWrittenBy(author: Writer): Boolean = author.name == this.author.name
  def copy(newYear: Int): Book = new Book(this.name, newYear, this.author)

}

class Counter(val i: Int = 0) {

  def currentCount(): Int = this.i
  //immutability
  //whenever the contents of an instance needs to be modified, you have to return a new instance
  def increment(step: Int = 1): Counter = new Counter(this.i + step)

}
