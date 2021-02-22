import org.scalatest.funsuite.AnyFunSuite

import main.Main.compose

class ComposeTest extends AnyFunSuite {
  test("compose") {
    var addFive = (a: Int) => a + 5
    var addTen = (a: Int) => a + 10
    var addMultilple = compose[Int, Int, Int](addFive, addTen)
    assert(addMultilple(5) == 20)
  }
}