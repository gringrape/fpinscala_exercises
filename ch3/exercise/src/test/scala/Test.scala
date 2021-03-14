import org.scalatest.funsuite.AnyFunSuite

import datastructures.List
import datastructures.List.matched
import datastructures.List.tail

class Test extends AnyFunSuite {
  test("Problem 3.1") {
    assert(matched(List(1, 2, 3, 4, 5)) == 3)
  }
  test("Problem 3.2") {
    assert(tail(List(1, 2, 3, 4, 6)) == List(2, 3, 4, 6))
    assert(tail(List(1)) == List())
  }
}
