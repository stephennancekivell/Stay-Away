package info.stephenn.game1

import org.junit._
import org.junit.Assert._
import info.stephenn.game1.party._

class RunAwayTest {
  
  @Test
  def whenPlayerIsCloseToEnemy = {
    val player = new Player()
    val world = new World()
    val enemy = new Enemy(world)
    
    player.x = 50
    player.y = 50
    enemy.x = 50
    enemy.y = 50
    
    assertTrue(RunAway.isPlayerNearEnemy(player, enemy))
  }
  
  @Test
  def whenPlayerIsFarFromEnemy = {
    val player = new Player()
    val world = new World()
    val enemy = new Enemy(world)
    
    player.x = 50
    player.y = 50
    enemy.x = 81
    enemy.y = 81
    
    assertFalse(RunAway.isPlayerNearEnemy(player, enemy))
  }
}