package info.stephenn.game1

import org.newdawn.slick.AppGameContainer
import org.newdawn.slick.BasicGame
import org.newdawn.slick.GameContainer
import org.newdawn.slick.Graphics
import org.newdawn.slick.SlickException

object App {
  
  def foo(x : Array[String]) = x.foldLeft("")((a,b) => a + b)
  
  def main(args : Array[String]) {
    println( "Hello World!" )
    println("concat arguments = " + foo(args))
    
    val app = new AppGameContainer(new App())
 
         app.setDisplayMode(800, 600, false);
         app.start();
    
    
  }

}

class App extends BasicGame("Slick2DPath2Glory - SimpleGame") {
 
  
  override def init(gc: GameContainer):Unit = {}
  
  override def update(gc: GameContainer, delta: Int): Unit = {}
  
  override def render(gc: GameContainer, g: Graphics): Unit = {}
  
}
