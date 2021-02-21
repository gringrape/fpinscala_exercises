package main

import scala.annotation.tailrec

object Main extends App {
  def factorial(n: Int): Int = {
    @tailrec
    def go(n: Int, acc: Int): Int = {
      if (n > 1) go(n - 1, n * acc)
      else acc
    }
    go(n, 1)
  }

  def fib(n: Int): Int = {
    @tailrec
    def go(n: Int, a: Int, b: Int): Int = {
      if (n == 1) a
      else go(n - 1, b, a + b)
    }
    go(n, 0, 1)
  }

  def isSorted[A](as: Array[A], ordered: (A, A) => Boolean): Boolean = {
    @tailrec
    def go(n: Int): Boolean = {
      if (n >= as.length - 1) true
      else if(!ordered(as(n), as(n + 1))) false
      else go(n + 1)
    }
    go(0)
  }

  def sum(a: Int, b: Int): Int = {
    a + b
  }

  def curry[A, B, C](f: (A, B) => C): A => (B => C) = {
    (a: A) => (b: B) => f(a, b)
  }

  def uncurry[A, B, C](f: A => B => C): (A, B) => C = {
    (a: A, b: B) => f(a)(b)
  }
}
