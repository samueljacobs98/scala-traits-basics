@main def main(): Unit = {
  val queue0 = new BasicIntQueue

  queue0.put(10)
  queue0.put(20)

  val res0 = queue0.get() // 10
  val res1 = queue0.get() // 20

  println(s"res0: $res0")
  println(s"res1: $res1")

  // We can add additional methods / override class methods using traits
  // create an instantiation of the class and add "with" the trait desired
  // i.e. BasicIntQueue with Doubling
  val queue1 = new BasicIntQueue with Doubling

  queue1.put(10)
  queue1.put(20)

  val res2 = queue1.get() // 20
  val res3 = queue1.get() // 40

  println(s"res2: $res2")
  println(s"res3: $res3")

  // Can be directly implemented by creating a new class (i.e. LessBasicQueue)
  val queue2 = new LessBasicQueue
  queue2.put(10)
  queue2.put(20)

  val res4 = queue2.get() // 20
  val res5 = queue2.get() // 40

  println(s"res4: $res4")
  println(s"res5: $res5")

  // We can stack multiple traits into a class using the 'with' keyword
  // Though we can use commas when doing this in a class, we must use
  // the 'with' keyword for anonymous classes as below
  val queue3 = new BasicIntQueue with Incrementing with Filtering
  queue3.put(-1)
  queue3.put(0)
  queue3.put(1)

  // Because we have implemented the filtering trait the first put does not
  // add a value to the queue
  val res6 = queue3.get() // 1
  val res7 = queue3.get() // 2

  println(s"res6: $res6")
  println(s"res7: $res7")

  // The order of mixins (when a trait is used with a class it can be
  // referred to as a mixin) is significant.
  // When calling a method on a class with mixins, the method in the
  // trait furthest to the right is called first.
  // if that method calls super, it invokes the method in the next
  // trait to the left/
  val queue4 = new BasicIntQueue with Filtering with Incrementing
  queue4.put(-1)
  queue4.put(0)
  queue4.put(1)

  // Because we have implemented the Filtering trait first, Incrementing is
  // called first. Therefore, the value -1 is incremented to 0 and thus
  // is not filtered out by the filtering mixin
  val res8 = queue4.get() // 0
  val res9 = queue4.get() // 1
  val res10 = queue4.get() // 2

  println(s"res8: $res8")
  println(s"res9: $res9")
  println(s"res10: $res10")

  // Therefore, traits are extremely powerful as we can stack
  // modifications from small sections of code.
  // You can define sixteen different classes by mixing in the three
  // traits that have been defined in different orders and combinations.

  val queue5 = new BasicIntQueue with Incrementing with Doubling

  queue5.put(42)

  val res11 = queue5.get()

  println(s"res11: $res11")
}

