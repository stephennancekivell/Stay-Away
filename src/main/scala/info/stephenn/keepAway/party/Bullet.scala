package info.stephenn.keepAway.party

import info.stephenn.keepAway.World

class Bullet(startX:Int, startY:Int, dx: Int, dy: Int) extends Party(startX, startY) {
  override val IMAGE_PATH = "yellow_ball.png"
  override val speed = 7
  
  def act {
    x += dx * speed
    y += dy * speed
  }

  def isOffWorld(world: World) = {
    ((x < 0 | x > world.SIZE_X) |
      (y < 0 | y > world.SIZE_Y))
  }
}