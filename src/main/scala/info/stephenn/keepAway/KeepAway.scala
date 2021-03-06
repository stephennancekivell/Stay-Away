package info.stephenn.keepAway

import org.newdawn.slick.AppGameContainer
import org.newdawn.slick.BasicGame
import org.newdawn.slick.GameContainer
import org.newdawn.slick.Graphics
import org.newdawn.slick.Image
import org.newdawn.slick.Input
import org.newdawn.slick.SlickException
import org.apache.commons.logging.LogFactory
import org.newdawn.slick.Color

import info.stephenn.keepAway.party._

import scala.collection.mutable.Set
import scala.util.Random

class KeepAway extends BasicGame("Keep Away") {
  val log = LogFactory.getLog(getClass)
  val world = new World(800, 600)

  var parties: Set[Party] = Set()
  val player: Player = new Player(world.SIZE_X/2, world.SIZE_Y/2)
  parties += player
  def enemies = parties collect { case e: Enemy => e }
  def bullets = parties collect { case b: Bullet => b }

  var isRunning = false
  var gameOver = false
  var score = 0

  override def init(gc: GameContainer) {
    player.init
    enemies.foreach(_.init)
  }

  override def update(gc: GameContainer, delta: Int) {
    if (isPlayerTouchingAnEnemy) {
      isRunning = false
      gameOver = true
    }

    if (isRunning) {
      handlePlayingInput(gc.getInput)
      removeShotEnemies

      enemies.foreach(_.act(player))
      bullets.foreach(bullet => {
        bullet.act
        if (bullet.isOffWorld(world)) {
          parties.remove(bullet)
        }
      })

      makeNewEnemies
    } else {
      handleMenuInput(gc.getInput)
    }
  }

  def newEnemyAtRandomEdge = {
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
    bullets.foreach(bullet => enemies.foreach(enemy => if (bullet.isNear(enemy)) {
      parties.remove(enemy)
      score += 1
    }))
  }

  var lastEnemyTime = 0l
  var enemiesToAdd = 1
  def makeNewEnemies {
    if (System.currentTimeMillis - lastEnemyTime > (1000 * 5)) {
      for (x <- 0 to enemiesToAdd) parties += newEnemyAtRandomEdge.init
      lastEnemyTime = System.currentTimeMillis
      enemiesToAdd += 1
    }
  }

  def handlePlayingInput(input: Input) {
    if (input.isKeyDown(Input.KEY_LEFT)) player.moveLeft
    if (input.isKeyDown(Input.KEY_RIGHT)) player.moveRight
    if (input.isKeyDown(Input.KEY_UP)) player.moveUp
    if (input.isKeyDown(Input.KEY_DOWN)) player.moveDown
    if (input.isKeyDown(Input.KEY_SPACE)) parties.add(player.shoot)
  }

  def handleMenuInput(input: Input) {
    if (input.isKeyDown(Input.KEY_SPACE) | input.isKeyDown(Input.KEY_SPACE)) {
      isRunning = !isRunning
    }
  }

  override def render(gc: GameContainer, g: Graphics) {
    g.drawString("Score: " + score, world.SIZE_X - 100, 5)
    if (isRunning)
      parties.foreach(_.draw)
    else {
      if (gameOver)
        g.drawString("Game Over!", world.SIZE_X / 2, world.SIZE_Y / 2)
      else {
        drawWelcomeMessages(Array("Keep the reds away from the blue.","Press space to shoot.","Arrows to move.","Press Space to start."),g)
      }
    }
  }
  
  def drawWelcomeMessages(lines: Array[String], g: Graphics) {
    lines.foreach(line => {
      g.drawString(line,
          (world.SIZE_X / 2) - (line.length / 2 * 10),
          (world.SIZE_Y / 2) + (20 * lines.indexOf(line)) - (lines.size * 10))
    })
  }

  def isPlayerTouchingAnEnemy = {
    enemies.map(player.isNear(_)).fold(false)(_ || _)
  }
}

object KeepAway {
  def main(args: Array[String]) {
    val app = new AppGameContainer(new KeepAway())
    app.setDisplayMode(800, 600, false)
    app.setShowFPS(false)
    app.start
  }
}