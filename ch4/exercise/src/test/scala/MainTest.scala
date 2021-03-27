import org.scalatest.funsuite.AnyFunSuite

import main.Main._
import java.io.FileNotFoundException

class MainTest extends AnyFunSuite {
  test("mean returns average value") {
    assert(mean(List(3, 4, 5)) == 4)

  }
  test("mean throws exception when sequence length is equal to zero") {
    var caught = intercept[Exception] {
      mean(List())
    }

    assert(caught.getMessage == "fail")
  }
}
