package info.stephenn.game1.party

import info.stephenn.game1._
import scala.util.Random
import org.newdawn.slick.Image

class Enemy(world: World, startX: Int, startY: Int) extends Party(startX, startY) {
  override val IMAGE_PATH = "red_ball.png"
  override val speed = 1
  
  def act(player: Player) {
    moveTowardParty(player)
    wrapAroundWorld
  }

  def moveTowardParty(p: Party) {
    if (p.x > x)
      x += speed
    else x -= speed
    if (p.y > y)
      y += speed
    else y -= speed
  }

  def wrapAroundWorld {
    if (x < 0)
      x = world.SIZE_X
    if (y < 0)
      y = world.SIZE_Y
  }
}