package option

import scala.{Option => _, Either => _, _}
import org.scalactic.anyvals.NonZeroDouble

// sealed trait Option[+A]
// case class Some[+A](get: A) extends Option[A]
// case object None extends Option[Nothing]

sealed trait Option[+A] {
  def map[B](f: A => B): Option[B] = this match {
    case None    => None
    case Some(a) => Some(f(a))
  }

  def getOrElse[B >: A](default: => B): B = this match {
    // Some 안의 결과를 돌려주거나, 기본값을 돌려준다
    case None    => default
    case Some(a) => a
  }

  def orElse[B >: A](ob: => Option[B]): Option[B] =
    this.map(Some(_)).getOrElse(ob)

  /*
   * f 를 적용하면 Option(Option) 형태가 된다.
   * getOrElse 를 이용하면 한꺼풀 벗겨줄 수 있다.
   */
  def flatMap[B](f: A => Option[B]): Option[B] = this.map(f).getOrElse(None)

  def filter(f: A => Boolean): Option[A] = {
    // 값이 f 를 만족하지 않으면 Some 을 None 으로 변환한다.
    this.flatMap((a) => {
      if (f(a)) Some(a)
      else None
    })
  }
}
case class Some[+A](get: A) extends Option[A]
case object None extends Option[Nothing]
