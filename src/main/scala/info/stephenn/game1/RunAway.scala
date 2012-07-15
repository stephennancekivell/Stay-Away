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
import scala.util.Random

class RunAway extends BasicGame("title") {
  val log = LogFactory.getLog(getClass)
  val world = new World(800,600)

  var parties: Set[Party] = Set()
  val player: Player = new Player()
  parties += player
  def enemies = parties.filter(_.getClass == classOf[Enemy]).map(_.asInstanceOf[Enemy])
  def bullets = parties.filter(_.getClass == classOf[Bullet]).map(_.asInstanceOf[Bullet])
  val NO_ENEMIES = 10
  for (x <- 0 to NO_ENEMIES) parties += newEnemyAtRandomEdge

  override def init(gc: GameContainer) {
    player.init
    enemies.foreach(_.init)
  }

  override def update(gc: GameContainer, delta: Int) {
    handleInput(gc.getInput)

    if (isPlayerTouchingAnEnemy)
      System.exit(0) //TODO game over message.

    removeShotEnemies

    enemies.foreach(_.act)
    bullets.foreach(_.act)

    makeNewEnemies
  }

  def newEnemyAtRandomEdge = {
    log.info("new Enemy at random edge")
    if (Random.nextBoolean) {
      if (Random.nextBoolean)
        new Enemy(world, Random.nextInt.abs % world.SIZE_X, 0)
      else
        new Enemy(world, Random.nextInt.abs % world.SIZE_X, world.SIZE_Y)
    } else {
      if (Random.nextBoolean)
        new Enemy(world, 0, Random.nextInt.abs % world.SIZE_Y)
      else
        new Enemy(world, world.SIZE_X, Random.nextInt.abs % world.SIZE_Y)
    }
  }

  def removeShotEnemies {
    bullets.foreach(b => enemies.map(e => {
      if (b.isNear(e)) {
        parties.remove(e)
        log.info("enemy has been shot")
      }
    }))
  }

  def makeNewEnemies {
    if (enemies.size < 10) {
      log.info("makeNew" + enemies.size)
      parties += newEnemyAtRandomEdge.init
    }
  }

  def handleInput(input: Input) {
    if (input.isKeyDown(Input.KEY_LEFT)) player.moveLeft
    if (input.isKeyDown(Input.KEY_RIGHT)) player.moveRight
    if (input.isKeyDown(Input.KEY_UP)) player.moveUp
    if (input.isKeyDown(Input.KEY_DOWN)) player.moveDown
    if (input.isKeyDown(Input.KEY_SPACE)) parties.add(player.shoot)
  }

  override def render(gc: GameContainer, g: Graphics) {
    parties.foreach(_.draw)
  }

  def isPlayerTouchingAnEnemy = {
    enemies.map(player.isNear(_)).reduce(_ || _)
  }
}

object RunAway {
  def main(args: Array[String]) {
    val app = new AppGameContainer(new RunAway())
    app.setDisplayMode(800, 600, false)
    app.start
  }
}