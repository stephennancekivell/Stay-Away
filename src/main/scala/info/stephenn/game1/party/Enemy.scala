package info.stephenn.game1.party

import info.stephenn.game1._
import scala.util.Random

class Enemy(world: World) extends Party {
  override val CHARACTER = "E"
  val r = new Random
  x = world.SIZE_X - 50
  y = world.SIZE_Y - 50

  def act {
    if (Random.nextBoolean)
      x = x + 1 % world.SIZE_X
    else
      x = x - 1 % world.SIZE_X
    if (Random.nextBoolean)
      y = y + 1 % world.SIZE_Y
    else
      y = y - 1 % world.SIZE_Y
  }
}