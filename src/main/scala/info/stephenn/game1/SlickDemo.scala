package info.stephenn.game1

import org.newdawn.slick.AppGameContainer
import org.newdawn.slick.BasicGame
import org.newdawn.slick.GameContainer
import org.newdawn.slick.Graphics
import org.newdawn.slick.Image
import org.newdawn.slick.Input
import org.newdawn.slick.SlickException

class SlickDemo extends BasicGame("title") {
  var blue: Image = _
  var red: Image = _

  override def init(gc: GameContainer) {
    blue = new Image("blue_ball.png")
    red = new Image("red_ball.png")

  }

  override def update(gc: GameContainer, delta: Int) {

  }

  override def render(gc: GameContainer, g: Graphics) {
    blue.draw(50, 50)
    red.draw(100, 100)
  }
}

object SlickDemo {
  def main(args: Array[String]) {
     val app = new AppGameContainer(new SlickDemo())
      app.setDisplayMode(800, 600, false)
      app.start
  }
}