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

  override def paint(graphics: Graphics) = {
    graphics.drawRect(square_x % SIZE_X, square_y % SIZE_Y, 10, 20)
  }

  def go = {
    log.info("go")
    frame.setSize(SIZE_X, SIZE_Y)
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE)
    frame.getContentPane.add(this)
    frame.setVisible(true)
    this.addKeyListener(new KeyInputHandler)
    
    while(true){
      Thread.sleep(UPDATE_TIME)
      updateLogic
      this.getGraphics.clearRect(0, 0, SIZE_X, SIZE_Y)
      this.paint(getGraphics)
    }
  }

  def updateLogic: Unit = {
    square_x += 1
    square_y += 1
  }
}