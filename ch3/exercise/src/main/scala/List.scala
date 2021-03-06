package datastructures

import scala.annotation.tailrec

sealed trait List[+A]
case object Nil extends List[Nothing]
case class Cons[+A](head: A, tail: List[A]) extends List[A]

object List {
  def tail(ints: List[Int]) = ints match {
    // TODO: Nil 인 경우도 고려
    case Cons(h, t) => t
  }

  // Example
  def sum(ints: List[Int]): Int = ints match {
    case Nil         => 0
    case Cons(x, xs) => x + sum(xs)
  }

  // Example
  def product(ds: List[Double]): Double = ds match {
    case Nil          => 1.0
    case Cons(0.0, _) => 0.0
    case Cons(x, xs)  => x * product(xs)
  }

  // Problem 3.1
  def matched(target: List[Int]) = target match {
    case Cons(x, Cons(2, Cons(4, _)))          => x
    case Nil                                   => 42
    case Cons(x, Cons(y, Cons(3, Cons(4, _)))) => x + y
    case _                                     => 101
  }

  // // Promblem 3.2
  // def tail(target: List[Int]): List[Int] = target match {
  //   case Nil        => sys.error("No list is given")
  //   case Cons(_, x) => x
  // }

  // Problem 3.3
  def setHead(list: List[Int], n: Int) = list match {
    case Cons(_, tail) => Cons(n, tail)
  }

  // Problem 3.4
  // 첫번째 방법 - 재귀함수를 통해서 반복을 처리해 주었다.
  def drop(list: List[Int], n: Int): List[Int] = {
    if (n <= 0) list
    else
      list match {
        case Cons(_, tail) => drop(tail, n - 1)
      }
  }

  // Problem 3.6 - 절반의 성공
  def init(l: List[Int]): List[Int] = l match {
    case Cons(h, Nil) => Nil
    case Cons(h, t)   => Cons(h, init(t))
  }

  def init2(l: List[Int]): List[Int] = {
    import collection.mutable.ListBuffer
    val buf = new ListBuffer[Int]
    @tailrec
    def go(cur: List[Int]): List[Int] = cur match {
      case Cons(_, Nil) => List(buf.toList: _*) // 이 부분의 타입 지정이 이해가진 않는다.
      case Cons(h, t)   => buf.addOne(h); go(t)
    }
    go(l)
  }

  def foldRight[A, B](as: List[A], z: B)(f: (A, B) => B): B = {
    as match {
      case Nil         => z
      case Cons(x, xs) => f(x, foldRight(xs, z)(f))
    }
  }

  def length[A](as: List[A]): Int = {
    foldRight(as, 0)((_, b) => b + 1)
  }

  @tailrec
  def foldLeft[A, B](as: List[A], z: B)(f: (B, A) => B): B = as match {
    case Nil        => z
    case Cons(h, t) => foldLeft(t, f(z, h))(f)
  }

  def sum2(l: List[Int]): Int = {
    foldLeft(l, 0)(_ + _)
  }

  def product2(l: List[Double]): Double = { // 타입은 직접건네주지 않았는데 어떻게 결정된걸까?
    foldLeft(l, 1.0)(_ * _)
  }

  def length2(l: List[Int]): Int = {
    foldLeft(l, 0)((a, _) => a + 1)
  }

  def reverse[A](l: List[A]): List[A] = {
    foldLeft(l, Nil: List[A])((b, a) => Cons(a, b))
  }

  def foldRightViaFoldLeft[A, B](l: List[A], z: B)(f: (A, B) => B): B =
    foldLeft(reverse(l), z)((b, a) => f(a, b))

  def append[A](l: List[A], x: List[A]): List[A] = {
    foldRight(l, x)(Cons(_, _))
  }

  def addOne(l: List[Int]): List[Int] = {
    foldRight(l, Nil: List[Int])((h, t) => Cons(h + 1, t))
  }

  def map_test[A, B](l: List[A], f: A => B): List[B] = {
    foldRight(l, Nil: List[B])((h, t) => Cons(f(h), t))
  }

  def convertToString(l: List[Double]) = {
    map_test(l, (d: Double) => d.toString())
  }

  def map[A, B](l: List[A])(f: A => B): List[B] = {
    foldRight(l, Nil: List[B])((h, t) => Cons(f(h), t))
  }

  def filter[A](as: List[A])(f: A => Boolean) = {
    // List(1, 2, 3, 4, 5)
    foldRight(as, Nil: List[A])((h, t) => {
      if (f(h)) Cons(h, t)
      else t
    })
  }

  def flatMap[A](as: List[A])(f: A => List[A]) = {
    // List(1, 1, 2, 2, 3, 3)
    foldRight(as, Nil: List[A])((h, t) => {
      append(f(h), t)
    })
  }

  def sumEach(l1: List[Int], l2: List[Int]): List[Int] = (l1, l2) match {
    case (Nil, _)                     => Nil
    case (_, Nil)                     => Nil
    case (Cons(h1, t1), Cons(h2, t2)) => Cons((h1 + h2), sumEach(t1, t2))
  }

  // 이게 없으면 자료구조를 쓸수가 없다
  def apply[A](as: A*): List[A] = {
    if (as.isEmpty) Nil
    else Cons(as.head, apply(as.tail: _*))
  }

  def take(list: List[Int], n: Int) = Cons(3, Nil)
}
