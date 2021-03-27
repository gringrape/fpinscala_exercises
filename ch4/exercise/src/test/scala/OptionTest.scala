import org.scalatest.funsuite.AnyFunSuite

import option.Option

class OptionTest extends AnyFunSuite {
  test("map") {
    assert(Option(3).map(_ + 10) == Some(13))
    // assert(Option((() => {
    //   throw new Exception("fail")
    // })()) == None)
  }

  test("getOrElse") {
    assert(Option(3).getOrElse(2) == 3)
  }
}
