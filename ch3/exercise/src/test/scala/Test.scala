import org.scalatest.funsuite.AnyFunSuite

import datastructures.List
import datastructures.List._

class Test extends AnyFunSuite {
  test("Problem 3.1") {
    assert(matched(List(1, 2, 3, 4, 5)) == 3)
  }

  test("Problem 3.2") {
    assert(tail(List(1, 2, 3, 4, 6)) == List(2, 3, 4, 6))
    assert(tail(List(1)) == List())
  }

  test("Problem 3.3") {
    assert(setHead(List(1, 2, 3, 4, 5), 3) == List(3, 2, 3, 4, 5))
    assert(setHead(List(1, 2), 5) == List(5, 2))
  }

  test("Problem 3.4") {
    assert(drop(List(1, 3, 2, 4), 2) == List(2, 4))
    assert(drop(List(1, 2, 3), 5) == List())
  }

  test("Problem 3.5") {
    assert(dropWhile[Int](List(2, 4, 3, 5), _ % 2 == 0) == List(3, 5))
  }

  test("Problem 3.6") {
    assert(init(List(1, 2, 3, 4)) == List(1, 2, 3))
    // assert(init(List(1, 2, 3, 4, 5)) == List(1, 2, 3, 4))
  }

  test("Problem 3.6 part2") {
    assert(init(List(1, 2, 3, 4)) == List(1, 2, 3))
  }

  test("foldRight example") {
    assert(foldRight(List(1, 2, 3, 4), 0)(_ + _) == 10)
    assert(foldRight(List(1, 2, 3, 4, 5), 1)(_ * _) == 120)
  }
}
