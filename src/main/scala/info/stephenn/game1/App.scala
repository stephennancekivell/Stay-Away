package info.stephenn.game1

import java.awt._
import javax.swing._
import org.apache.commons.logging._
import info.stephenn.game1.party._

object App {
  def main(args: Array[String]) {
    new App().go
  }
}

class App extends Canvas {
  val log = LogFactory.getLog(getClass)
  val frame = new JFrame()
  val UPDATE_TIME = 100
  val player = new Player()
  val world = new World()
  val enemy = new Enemy(world)

  implicit val graphics = getGraphics

  override def paint(graphics: Graphics) = {
    player.draw(graphics)
    enemy.draw(graphics)
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
    enemy.act
  }
}