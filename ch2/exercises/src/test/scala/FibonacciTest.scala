import org.scalatest.funsuite.AnyFunSuite

import main.Main.fib

class FibonacciTest extends AnyFunSuite {
  test("fib") {
    assert(fib(1) == 0)
    assert(fib(2) == 1)
    assert(fib(3) == 1)
    assert(fib(4) == 2)
    assert(fib(5) == 3)
    assert(fib(31) == 832040)
  }  
}
