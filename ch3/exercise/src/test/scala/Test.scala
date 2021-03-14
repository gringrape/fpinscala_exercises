import org.scalatest.funsuite.AnyFunSuite

import datastructures.List
import datastructures.List.matched

class Test extends AnyFunSuite {
  test("Problem 3.1") {
    assert(matched(List(1, 2, 3, 4, 5)) == 3)
  }
}
