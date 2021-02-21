import org.scalatest.funsuite.AnyFunSuite

import main.Main.isSorted

class IsSortedTest extends AnyFunSuite {
  test("check if given array is sorted") {
    assert(isSorted[Int](Array(1, 2), (a, b) => a < b) == true)
    assert(isSorted[Int](Array(1, 2, 3), (a, b) => a < b) == true)
    assert(isSorted[Int](Array(1, 2, 4, 3), (a, b) => a < b) == false)
  }
}