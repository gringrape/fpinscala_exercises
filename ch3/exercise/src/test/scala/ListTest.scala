import org.scalatest.funsuite.AnyFunSuite

import datastructures.List
import datastructures.List.sum
import datastructures.List.product

class MainTest extends AnyFunSuite {
  test("test sum") {
    assert(sum(List(1, 2, 3)) == 6)
  }

  test("test multiply") {
    assert(product(List(3.0, 5.0)) == 15.0)
    assert(product(List(3.0, 0.0, 2.0)) == 0)
  }
}
