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
  val SIZE_X = 200
  val SIZE_Y = 200

  def init = {
    image = new Image(IMAGE_PATH)
    this
  }

  def draw {
    image.draw(x, y, SIZE_X, SIZE_Y)
  }
  
  def isNear(p: Party) = {
    val THRESHOLD = 30
    if ((x - p.x).abs < THRESHOLD &&
      (y - p.y).abs < THRESHOLD)
      true
    else
      false
  }
}