package parallelism.locking

import java.util.concurrent.Semaphore

/**
 * Created by prayagupd 
 * on 6/22/16.
 */

object DatabaseConnectionsUsingSemaphore {

}

class TableLock {

  val readLock = new Semaphore(10)
  val writeLock = new Semaphore(1)

  object SingletonHolder {
    val INSTANCE = new TableLock()
  }

  def getInstance() : TableLock = {
   SingletonHolder.INSTANCE
 }

  def getWriteLock() {
    writeLock.acquire()
  }

  def releaseWriteLock() {
    writeLock.release()
  }

  def getReadLock() {
    readLock.acquire()
  }

  def releaseReadLock() {
    readLock.release()
  }
}