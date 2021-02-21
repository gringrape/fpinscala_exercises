import org.scalatest.funsuite.AnyFunSuite

import main.Main.factorial

class FactorialTest extends AnyFunSuite {
  test("Factorial") {
    assert(factorial(1) == 1)
    assert(factorial(2) == 2)
    assert(factorial(3) == 6)
  }
}