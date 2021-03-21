import org.scalatest.funsuite.AnyFunSuite

import datastructures._

import datastructures.Tree._

class TreeTest extends AnyFunSuite {
  test("Problem 3.25") {
    assert(size(Branch(Leaf(1), Leaf(2))) == 2)
  }
}
