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

  def act {
    if (Random.nextBoolean)
      x = x + speed % world.SIZE_X
    else
      x = x - speed % world.SIZE_X
    if (Random.nextBoolean)
      y = y + speed % world.SIZE_Y
    else
      y = y - speed % world.SIZE_Y
  }
}