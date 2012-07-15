package info.stephenn.game1.party

import java.awt.Graphics
import org.apache.commons.logging.LogFactory
import org.newdawn.slick.Image

class Party {
  val IMAGE_PATH = "red_ball.png"
  var image: Image = _
  val log = LogFactory.getLog(getClass)
  var x = 200
  var y = 200
  val speed = 3
  
  def init { image = new Image(IMAGE_PATH) }

  def draw = {
    log.info("draw")
    image.draw(x, y)
  }
}