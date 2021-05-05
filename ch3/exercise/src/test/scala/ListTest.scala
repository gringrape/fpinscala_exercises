import org.scalatest.funsuite.AnyFunSuite

import datastructures.List
import datastructures.List.sum
import datastructures.List.product
import datastructures.List.tail
import datastructures.List.setHead
import datastructures.List.drop
import datastructures.List.take

class MainTest extends AnyFunSuite {
  test("tail") {
    assert(tail(List(1, 2, 3)) == List(2, 3))
  }

  test("setHead") {
    assert(setHead(List(1, 2, 3), 5) == List(5, 2, 3))
  }

  test("drop") {
    assert(drop(List(1, 2, 3), 2) == List(3))
  }

  test("take") {
    assert(take(List(2, 3, 4, 5), 3) == List(3))
  }
}
