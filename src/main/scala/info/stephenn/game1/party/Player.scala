package info.stephenn.game1.party

import org.newdawn.slick.Image
import org.newdawn.slick.GameContainer
import org.newdawn.slick.Input

class Player extends Party {
  override val IMAGE_PATH = "blue_ball.png"
  override val speed = 3
  var dx:Int = _
  var dy:Int = _
  
  def moveLeft = {
    x -= speed
    dx = -1
    dy = 0
  }
  
  def moveRight = {
    x += speed
    dx = 1
    dy = 0
  }
  
  def moveUp = {
    y -= speed
    dy = -1
    dx = 0 
  }
  
  def moveDown = {
    y += speed
    dy = 1
    dx = 0
  }
  
  def shoot = new Bullet(x,y, dx, dy).init
}