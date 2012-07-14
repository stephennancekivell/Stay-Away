package info.stephenn.game1.party

import info.stephenn.game1._
import scala.util.Random

class Enemy(world: World) extends Party {
  override val CHARACTER = "E"
  val r = new Random
  override val speed = 4
  x = world.SIZE_X - 50
  y = world.SIZE_Y - 50

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