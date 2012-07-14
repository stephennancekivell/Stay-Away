package info.stephenn.game1.party

import info.stephenn.game1._

class Enemy(world: World) extends Party {
  override val CHARACTER = "E"
  
  def act {
    x = x+1 % world.SIZE_X
    y = y+1 % world.SIZE_Y
  }
}