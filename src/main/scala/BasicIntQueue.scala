import scala.collection.mutable.ArrayBuffer

class BasicIntQueue extends IntQueue: 
  private val buf = ArrayBuffer.empty[Int]
  override def get(): Int = buf.remove(0)
  override def put(x: Int): Unit = buf += x