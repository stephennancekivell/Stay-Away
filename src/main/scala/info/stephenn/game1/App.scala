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

  override def paint(graphics: Graphics) = {
    graphics.drawRect(10, 20, 10, 20)
  }

  def go = {
    frame.setSize(400, 400)
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE)
    frame.getContentPane.add(this)
    frame.setVisible(true)
  }

  def tick: Unit = {
    log.trace("tick")

  }
}