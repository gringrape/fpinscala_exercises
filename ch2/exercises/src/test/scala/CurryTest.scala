import org.scalatest.funsuite.AnyFunSuite

import main.Main.curry
import main.Main.sum
class CurryTest extends AnyFunSuite {
  test("should return curried function") {
    var curriedSum: Int => (Int => Int) = curry[Int, Int, Int](sum)
    var oneApplied: Int => Int = curriedSum(1)
    var threeApplied: Int => Int = curriedSum(3)

    assert(oneApplied(5) == 6)
    assert(threeApplied(10) == 13)
  }
}