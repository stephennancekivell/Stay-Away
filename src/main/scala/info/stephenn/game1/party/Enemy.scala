package info.stephenn.game1.party

import info.stephenn.game1._
import scala.util.Random
import org.newdawn.slick.Image

class Enemy(world: World, startX: Int, startY: Int) extends Party {
  override val IMAGE_PATH = "red_ball.png"
  val r = new Random
  override val speed = 4
  x = startX
  y = startY
  
  log.info("new Enemy x,y:"+x+","+y)

  def act {
    moveInRandomDirection
    wrapAroundWorld
  }
  
  def moveInRandomDirection {
    if (Random.nextBoolean)
      x = x + speed
    else
      x = x - speed
      
    if (Random.nextBoolean)
      y = y + speed
    else
      y = y - speed
  }
  
  def wrapAroundWorld {
    if (x < 0)
      x = world.SIZE_X
    if (y < 0)
      y = world.SIZE_Y
  }
}