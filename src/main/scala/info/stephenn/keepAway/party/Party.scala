package info.stephenn.keepAway.party

import org.apache.commons.logging.LogFactory
import org.newdawn.slick.Image

class Party(startX:Int, startY:Int) {
  val IMAGE_PATH = "red_ball.png"
  var image: Image = _
  val log = LogFactory.getLog(getClass)
  var x = startX
  var y = startY
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
    val THRESHOLD = 15
    if ((x - p.x).abs < THRESHOLD &&
      (y - p.y).abs < THRESHOLD)
      true
    else
      false
  }
}