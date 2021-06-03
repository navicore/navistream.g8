package $package$

import org.scalatest.flatspec.AnyFlatSpec
import org.scalatest.matchers.should

import scala.collection.mutable

class $name;format="Camel"$Spec extends AnyFlatSpec with should.Matchers {

  "A Stack" should "pop values in last-in-first-out order" in {
    //noinspection ScalaDeprecation
    val stack = new mutable.Stack[Int]
    stack.push(1)
    stack.push(2)
    
    stack.pop() should be (2)
    
    assert(stack.pop() === 1)
  }

  it should "throw NoSuchElementException if an empty stack is popped" in {
    //noinspection ScalaDeprecation
    val emptyStack = new mutable.Stack[String]
    assertThrows[NoSuchElementException] {
      emptyStack.pop()
    }
  }
}
