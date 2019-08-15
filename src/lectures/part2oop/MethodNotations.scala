package lectures.part2oop

object MethodNotations extends App {
  class Person(val name: String, val favoriteMovie: String, val age: Int = 0) {
    def likes(movie: String): Boolean = movie == favoriteMovie
    def hangOutWith(person: Person): String = s"${this.name} is hanging out with ${person.name}"
    def unary_! : String = "unary method called"
    def apply(): String = s"Hi my name is $name and I like $favoriteMovie"
    def +(nickname: String): Person = new Person(s"$name ($nickname)", favoriteMovie, age)
    def unary_+ : Person = new Person(name, favoriteMovie, age + 1 )
    def learns(thing: String): String = s"$name is learning $thing"
    def learnsScala : String = this learns "Scala"
    def apply(n: Int): String = s"$name watched $favoriteMovie $n times"

  }

  val mary = new Person("Mary", "Inception", 25)
  println(mary.likes("Inceptions"))
  println(mary likes "Inception") // infix notation, possible when a func receives one param

  val tom = new Person("Tom", "Fight Club", 25)
  println(mary hangOutWith tom)
  println(!mary)
  println(mary.unary_!)
  println(mary())
  println((mary + "this is a nickname")())
  println((+mary).age)
  println(mary.learnsScala)
  println(mary(10))
}
