package lectures.part1basics

object Expressions extends App {
  val x = 1 + 2
  println(x)

  val aCondition = true
  val aConditionValue = if(aCondition) 5 else 3 //IF EXPRESSION
  println(aConditionValue)

  //Side effects, or instructions in Scala returns Unit
  //Unit === Void in another languages

  val aCodeBlock = {
    val y = 2
    val z = y + 1

    if (z > 2) "hello" else "goodbye"
  }

  //The return value of a code block is the value of it's last expression
}
