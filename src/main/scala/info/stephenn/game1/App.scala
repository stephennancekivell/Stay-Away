package info.stephenn.game1

import java.awt._
import javax.swing._

object App {
  def main(args: Array[String]) {
    new App().go
  }
}

class App extends Canvas {
  val frame = new JFrame();

  def go = {
    frame.setSize(400, 400)
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE)
    frame.getContentPane.add(this)
    frame.setVisible(true)
  }
  
  def draw:Unit = {
    
  }
  
  def tick:Unit = {
    
  }
}