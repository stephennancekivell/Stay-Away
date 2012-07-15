package info.stephenn.game1

import org.newdawn.slick.AppGameContainer
import org.newdawn.slick.BasicGame
import org.newdawn.slick.GameContainer
import org.newdawn.slick.Graphics
import org.newdawn.slick.Image
import org.newdawn.slick.Input
import org.newdawn.slick.SlickException
import org.apache.commons.logging.LogFactory

import info.stephenn.game1.party._

import scala.collection.mutable.Set

class RunAway extends BasicGame("title") {
  val log = LogFactory.getLog(getClass)
  val world = new World()

  val player: Player = new Player()
  val enemies: Set[Enemy] = Set()
  val NO_ENEMIES = 10
  for (x <- 0 to NO_ENEMIES) enemies += new Enemy(world)

  override def init(gc: GameContainer) {
    player.init
    enemies.foreach(_.init)
  }

  override def update(gc: GameContainer, delta: Int) {
    val input = gc.getInput
    if (input.isKeyDown(Input.KEY_LEFT)) player.moveLeft
    if (input.isKeyDown(Input.KEY_RIGHT)) player.moveRight
    if (input.isKeyDown(Input.KEY_UP)) player.moveUp
    if (input.isKeyDown(Input.KEY_DOWN)) player.moveDown

    if (isPlayerTouchingAnEnemy)
      System.exit(0)

    enemies.foreach(_.act)
  }

  override def render(gc: GameContainer, g: Graphics) {
    player.draw
    enemies.foreach(_.draw)
  }

  def isPlayerTouchingAnEnemy: Boolean = {
    enemies.map(RunAway.isPlayerNearEnemy(player, _)).reduce(_ || _)
  }

}

object RunAway {
  def main(args: Array[String]) {
    val app = new AppGameContainer(new RunAway())
    app.setDisplayMode(800, 600, false)
    app.start
  }

  def isPlayerNearEnemy(p: Player, e: Enemy) = {
    val THRESHOLD = 30
    if ((e.x - p.x).abs < THRESHOLD &&
      (e.y - p.y).abs < THRESHOLD)
      true
    else
      false
  }
}