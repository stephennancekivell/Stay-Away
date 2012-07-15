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
  
  @Test
  def doesMoveTowardPartyA {
    val e = new Enemy(new World(10, 10), 0, 0)
    val p = new Player(5,5)
    
    e.moveTowardParty(p)
    assertEquals(4, e.x)
    assertEquals(4, e.y)
  }
  
  @Test
  def doesMoveTowardPartyB {
    val e = new Enemy(new World(10, 10), 9, 9)
    val p = new Player(5,5)
    
    e.moveTowardParty(p)
    assertEquals(5, e.x)
    assertEquals(5, e.y)
  }

}