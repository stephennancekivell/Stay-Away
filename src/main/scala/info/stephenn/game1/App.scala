package info.stephenn.game1

import java.awt._
import javax.swing._
import org.apache.commons.logging._
import info.stephenn.game1.party._
import scala.collection.mutable.Set

object App {
  val log = LogFactory.getLog(getClass)
  def main(args: Array[String]) {
    new App().go
  }

  def isPlayerNearEnemy(p: Player, e: Enemy) = {
    val THRESH_HOLD = 30
    if ((e.x - p.x).abs < THRESH_HOLD &&
      (e.y - p.y).abs < THRESH_HOLD)
      true
    else
      false
  }
}

class App extends Canvas {
  val log = LogFactory.getLog(getClass)
  val frame = new JFrame()
  val UPDATE_TIME = 50
  val player = new Player()
  val world = new World()
  val enemies: Set[Enemy] = Set()
  val NO_ENEMIES = 10

  for (x <- 0 to NO_ENEMIES) enemies += new Enemy(world)

  implicit val graphics = getGraphics

  override def paint(graphics: Graphics) = {
    player.draw(graphics)
    enemies.foreach(_.draw(graphics))
  }

  def go = {
    log.info("go")
    frame.setSize(world.SIZE_X, world.SIZE_Y)
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE)
    frame.getContentPane.add(this)
    frame.setVisible(true)
    addKeyListener(new KeyInputHandler(player))

    while (true) {
      updateLogic
      clear
      paint(getGraphics)
      Thread.sleep(UPDATE_TIME)
    }
  }

  def clear = getGraphics clearRect (0, 0, world.SIZE_X, world.SIZE_Y)

  def updateLogic: Unit = {
    if (isPlayerTouchingAnEnemy)
      System.exit(0)
    enemies.foreach(_.act)
  }

  def isPlayerTouchingAnEnemy: Boolean = {
    enemies.map(App.isPlayerNearEnemy(player, _)).reduce(_ || _)
  }
}