package info.stephenn.game1

import java.awt._
import javax.swing._
import org.apache.commons.logging._

object App {
  def main(args: Array[String]) {
    new App().go
  }
}

class App extends Canvas {
  val log = LogFactory.getLog(getClass)
  val frame = new JFrame()
  var square_x = 10
  var square_y = 10
  val SIZE_X = 400
  val SIZE_Y = 400
  val UPDATE_TIME = 100
  val player = new Player()

  implicit val graphics = getGraphics

  override def paint(graphics: Graphics) = {
    graphics.drawRect(square_x % SIZE_X, square_y % SIZE_Y, 10, 20)
    player.draw(getGraphics)
  }

  def go = {
    log.info("go")
    frame.setSize(SIZE_X, SIZE_Y)
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

  def clear = getGraphics clearRect (0, 0, SIZE_X, SIZE_Y)

  def updateLogic: Unit = {
    square_x += 1
    square_y += 1
  }
}