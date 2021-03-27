package main

object Main extends App {
  def mean(xs: Seq[Double]): Double = {
    if (xs.length == 0) throw new Exception("fail")
    xs.sum / xs.length
  }
}
