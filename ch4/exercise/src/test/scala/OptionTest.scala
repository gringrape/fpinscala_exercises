import org.scalatest.funsuite.AnyFunSuite

object Test {
  def mean(xs: Seq[Double]): Option[Double] = {
    if (xs.length == 0) None
    else Some(xs.sum / xs.length)
  }

  def variance(xs: Seq[Double]): Option[Double] = {
    mean(xs)
      .flatMap((m) => mean(xs.map((x) => Math.pow(x - m, 2))))
  }
}

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

  test("variance") {
    assert(Test.variance(Seq(4, 5, 6, 7)) == Some(1.25))
    assert(Test.variance(Seq()) == None)
  }
}
