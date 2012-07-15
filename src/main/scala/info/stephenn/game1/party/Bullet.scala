package info.stephenn.game1.party

import info.stephenn.game1.World

class Bullet(startX:Int, startY:Int, dx: Int, dy: Int) extends Party {
  override val speed = 7
  x = startX
  y = startY

  def act {
    x += dx * speed
    y += dy * speed
  }

  def isOffWorld(world: World) = {
    ((x < 0 | x > world.SIZE_X) &&
      (y < 0 | y > world.SIZE_Y))
  }
}