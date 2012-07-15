package info.stephenn.game1.party

import org.newdawn.slick.Image
import org.newdawn.slick.GameContainer
import org.newdawn.slick.Input

class Player extends Party {
  override val IMAGE_PATH = "blue_ball.png"
  override val speed = 3
  
  def moveLeft = x -= speed
  def moveRight = x += speed
  def moveUp = y -= speed
  def moveDown = y += speed
}