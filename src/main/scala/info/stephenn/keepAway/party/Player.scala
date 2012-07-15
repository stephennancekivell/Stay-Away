package info.stephenn.keepAway.party

import org.newdawn.slick.Image
import org.newdawn.slick.GameContainer
import org.newdawn.slick.Input

class Player(startX:Int, startY:Int) extends Party(startX, startY) {
  override val IMAGE_PATH = "blue_ball.png"
  override val speed = 3
  var dx:Int = 0
  var dy:Int = 1
  
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