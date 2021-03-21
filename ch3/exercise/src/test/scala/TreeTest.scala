import org.scalatest.funsuite.AnyFunSuite

import datastructures._

import datastructures.Tree._

class TreeTest extends AnyFunSuite {
  test("Problem 3.25") {
    assert(size(Branch(Leaf(1), Leaf(2))) == 2)
  }

  test("Problem 3.27") {
    assert(
      depth(
        Branch(
          Branch(
            Leaf(1),
            Leaf(2)
          ),
          Branch(
            Leaf(3),
            Branch(
              Leaf(4),
              Leaf(5)
            )
          )
        )
      ) == 3
    )
  }
}
