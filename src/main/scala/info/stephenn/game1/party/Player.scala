package info.stephenn.game1.party

class Player extends Party {
  override val CHARACTER = "X"
  override val speed = 3
  
  def moveLeft = x -= speed
  def moveRight = x += speed
  def moveUp = y -= speed
  def moveDown = y += speed
}