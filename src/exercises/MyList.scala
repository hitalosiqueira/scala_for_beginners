package exercises

abstract class MyList[+A] {
  def head: A
  def tail: MyList[A]
  def isEmpty: Boolean
  def add[B >: A] (elem: B): MyList[B]
  def map[B] (transformer: MyTransformer[A, B]): MyList[B]
  def flatMap[B] (transformer: MyTransformer[A, MyList[B]]): MyList[B]
  def filter(predicate: MyPredicate[A]): MyList[A]
  def ++[B >: A](list: MyList[B]): MyList[B]
  def printElements: String
  override def toString: String = "[" + printElements + "]"
}

trait MyPredicate[-T] {
  def test(elem: T): Boolean
}

trait MyTransformer[-A, B] {
  def transform(elem: A): B
}

object Empty extends MyList[Nothing] {
  override def head: Nothing = throw new NoSuchElementException
  override def tail: MyList[Nothing] = throw new NoSuchElementException
  override def isEmpty: Boolean = true
  override def add[B >: Nothing](elem: B): MyList[B] = new Cons(elem, Empty)
  override def map[B] (transformer: MyTransformer[Nothing, B]): MyList[B] = Empty
  override def flatMap[B] (transformer: MyTransformer[Nothing, MyList[B]]): MyList[B] = Empty
  override def filter(predicate: MyPredicate[Nothing]): MyList[Nothing] = Empty
  override def ++[B >: Nothing](list: MyList[B]): MyList[B] = list
  override def printElements: String = ""
}

class Cons[+A](h: A, t: MyList[A]) extends MyList[A] {
  override def head: A = h
  override def tail: MyList[A] = t
  override def isEmpty: Boolean = false
  override def add[B >: A] (elem: B): MyList[B] = new Cons(elem, this)

  override def filter(predicate: MyPredicate[A]): MyList[A] =
    if(predicate.test(h)) new Cons(h, t.filter(predicate))
    else t.filter(predicate)

  override def map[B](transformer: MyTransformer[A, B]): MyList[B] = new Cons(transformer.transform(h), t.map(transformer))
  override def ++[B >: A](list: MyList[B]): MyList[B] = new Cons(h, t ++ list)
  override def flatMap[B](transformer: MyTransformer[A, MyList[B]]): MyList[B] =
    transformer.transform(h) ++ t.flatMap(transformer)

  def printElements: String = {
    if (t.isEmpty) "" + h
    else h + " " + t.printElements
  }
}

object ListTest extends App {
  val listOfIntegers: MyList[Int] = new Cons(1, new Cons(2, new Cons(3, Empty)))
  val listOfStrings: MyList[String] = new Cons("Hello", new Cons("Scala", Empty))

  println(listOfIntegers.toString)
  println(listOfStrings.toString)

  println(listOfIntegers.map((elem: Int) => elem * 4).toString)
  println(listOfIntegers.filter((elem: Int) => elem % 2 == 0).toString)

  val anotherListOfIntegers: MyList[Int] = new Cons(4, new Cons(5, Empty))


  println((listOfIntegers ++ anotherListOfIntegers).toString)
  println(listOfIntegers.flatMap(new MyTransformer[Int, MyList[Int]] {
    override def transform(elem: Int): MyList[Int] = new Cons(elem, new Cons(elem + 1, Empty))
  }).toString)
}


