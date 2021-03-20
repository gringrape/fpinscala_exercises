import org.scalatest.funsuite.AnyFunSuite

import datastructures.List
import datastructures.List._

import datastructures._

class Test extends AnyFunSuite {
  test("Problem 3.1") {
    assert(matched(List(1, 2, 3, 4, 5)) == 3)
  }

  test("Problem 3.2") {
    assert(tail(List(1, 2, 3, 4, 6)) == List(2, 3, 4, 6))
    assert(tail(List(1)) == List())
  }

  test("Problem 3.3") {
    assert(setHead(List(1, 2, 3, 4, 5), 3) == List(3, 2, 3, 4, 5))
    assert(setHead(List(1, 2), 5) == List(5, 2))
  }

  test("Problem 3.4") {
    assert(drop(List(1, 3, 2, 4), 2) == List(2, 4))
    assert(drop(List(1, 2, 3), 5) == List())
  }

  test("Problem 3.5") {
    assert(dropWhile[Int](List(2, 4, 3, 5), _ % 2 == 0) == List(3, 5))
  }

  test("Problem 3.6") {
    assert(init(List(1, 2, 3, 4)) == List(1, 2, 3))
    // assert(init(List(1, 2, 3, 4, 5)) == List(1, 2, 3, 4))
  }

  test("Problem 3.6 part2") {
    assert(init(List(1, 2, 3, 4)) == List(1, 2, 3))
  }

  test("foldRight example") {
    assert(foldRight(List(1, 2, 3, 4), 0)(_ + _) == 10)
    assert(foldRight(List(1, 2, 3, 4, 5), 1)(_ * _) == 120)
    assert(
      foldRight(List(1, 2, 3), Nil: List[Int])(Cons(_, _)) == List(1, 2, 3)
    )
  }

  // Problem 3.7
  /*
    product 가 0 을 만난다고 해도 평가단축이 일어나지는 않는다. foldRight 의 첫번째 인수가
    Nil 이 될때까지 계속해서 호출이 일어나게 된다.
   */

  // Problem 3.8
  /*
    foldRight 을 이해하는 한가지 방법은, 그것이 Cons 생성자를 f 로, Nil 을 z 로 바꾼다는
    것이다. 따라서, 만약 f 에 다시 Cons 생성자를 넣고, z 자리에 다시 Nil 을 넣는다면,
    원래 목록이 나올 것이다.
   */

  test("Problem 3.9") {
    assert(length[Int](List(1, 2, 3, 5)) == 4)
    assert(length[Int](List(1, 2, 3, 5, 7, 8, 9)) == 7)
  }

  test("Problem 3.10") {
    assert(foldLeft(List(1, 2, 3, 4), 0)(_ + _) == 10)
  }

  test("Problem 3.11") {
    assert(sum2(List(1, 2, 3, 4, 5)) == 15)
    assert(product2(List(1, 2, 3, 5)) == 30)
    assert(length2(List(1, 2, 3, 4, 5, 6)) == 6)
  }

  test("Problem 3.12") {
    assert(reverse(List(1, 2, 3, 4)) == List(4, 3, 2, 1))
  }

  test("Problem 3.13") {
    assert(
      foldRightViaFoldLeft(List(1, 2, 3, 4), Nil: List[Int])(
        Cons(_, _)
      ) == List(1, 2, 3, 4)
    )
  }
}
