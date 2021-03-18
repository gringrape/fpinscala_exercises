package datastructures

sealed trait List[+A]
case object Nil extends List[Nothing]
case class Cons[+A](head: A, tail: List[A]) extends List[A]

object List {
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

  // Promblem 3.2
  def tail(target: List[Int]): List[Int] = target match {
    case Nil        => sys.error("No list is given")
    case Cons(_, x) => x
  }

  // Problem 3.3
  def setHead(list: List[Int], head: Int): List[Int] = list match {
    case Nil         => sys.error("No list is given")
    case Cons(_, xs) => Cons(head, xs)
  }

  // Problem 3.4
  // 첫번째 방법 - 재귀함수를 통해서 반복을 처리해 주었다.
  def drop(list: List[Int], n: Int): List[Int] = {
    if (n <= 0) list
    else
      list match {
        case Nil        => Nil
        case Cons(_, t) => drop(t, n - 1)
      }
  }

  // Problem 3.5
  def dropWhile[A](l: List[A], f: A => Boolean): List[A] = l match {
    case Cons(h, t) if (f(h)) => dropWhile(t, f)
    case _                    => l // 위에서 안걸리는 모든 경우를 다룰때, 이런 표현을 쓴다.
  }

  // 이게 없으면 자료구조를 쓸수가 없다
  def apply[A](as: A*): List[A] = {
    if (as.isEmpty) Nil
    else Cons(as.head, apply(as.tail: _*))
  }
}