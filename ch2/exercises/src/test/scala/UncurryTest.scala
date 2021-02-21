import org.scalatest.funsuite.AnyFunSuite

import main.Main.uncurry

class UncurryTest extends AnyFunSuite {
  var curriedSum: Int => Int => Int = a => b => a + b
  test("uncurries curried function") {
    var sum: (Int, Int) => Int = uncurry(curriedSum)
    assert(sum(5, 6) == 11)
  }
}