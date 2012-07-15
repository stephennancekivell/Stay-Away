package info.stephenn.game1.party

import org.junit.Test
import org.junit.Assert._

import info.stephenn.game1._

class BulletTest {
  
  @Test
  def whenIsOffWorld {
    val world = World(10,10)
    val bullet = new Bullet(2,2,-1,0)
    
    assertFalse(bullet.isOffWorld(world))
    
    bullet.act
    
    assertTrue(bullet.isOffWorld(world))
  }
}