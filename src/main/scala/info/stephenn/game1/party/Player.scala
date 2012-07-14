package info.stephenn.game1.party

class Player extends Party {
  override val CHARACTER = "X"
  def moveLeft = x -= 1
  def moveRight = x += 1
  def moveUp = y -= 1
  def moveDown = y += 1
}