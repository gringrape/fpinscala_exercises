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
}
