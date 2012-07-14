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
  var x1 = 10

  override def paint(graphics: Graphics) = {
    graphics.drawRect(x1, 20, 10, 20)
  }

  def go = {
    log.info("go")
    frame.setSize(400, 400)
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE)
    frame.getContentPane.add(this)
    frame.setVisible(true)
    
    while(true){
      Thread.sleep(100)
      updateLogic
    }
  }

  def updateLogic: Unit = {
    log.info("tick")
    x1 += 1

  }
}