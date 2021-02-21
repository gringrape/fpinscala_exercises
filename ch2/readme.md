## 2.2

- 주어진 비교 함수에 의해서 정렬되어 있는지 검사하는 함수를 구현

- 처음 풀이: acc 를 이용해서 풀이

```scala
  def isSorted[A](as: Array[A], ordered: (A, A) => Boolean): Boolean = {
    @tailrec
    def go(n: Int, acc: Boolean): Boolean = {
      if (n == as.length - 1) acc
      else go(n + 1, acc && ordered(as(n), as(n + 1)))
    }
    go(0, true)
  }

```

- 나중 풀이: acc 를 이용하지 않고 풀이

```scala
  def isSorted[A](as: Array[A], ordered: (A, A) => Boolean): Boolean = {
    @tailrec
    def go(n: Int): Boolean = {
      if (n >= as.length - 1) true
      else if(!ordered(as(n), as(n + 1))) false
      else go(n + 1)
    }
    go(0)
  }
```

- 배운 것.
  - 굳이 acc 를 써야 꼬리재귀는 아니다 -> 연산자가 끼어들지 않으면 된다. 

## 2.3

- sum(a, b) 를 커링하는 함수를 작성한다고 생각했다.

- sum 을 하나의 인자씩 나누어서 적용하는 형태로 바꿔 준다는 인터페이스에 맞춰서 테스트를 작성해주었다.
- 함수 형식은 anonymous 형식으로 지정해주면 된다. 

