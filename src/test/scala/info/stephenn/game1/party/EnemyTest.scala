package info.stephenn.game1.party

import org.junit.Test
import org.junit.Assert._
import info.stephenn.game1._

class EnemyTest {
  
  @Test
  def doesWrapIfOffScreen {
    val e = new Enemy(new World(10, 10), -1, -1)
    e.wrapAroundWorld
    
    assertEquals(10, e.x)
    assertEquals(10, e.y)
  }

}