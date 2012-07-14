package info.stephenn.game1

import java.awt.event.KeyAdapter
import java.awt.event.KeyEvent
import org.apache.commons.logging.LogFactory

class KeyInputHandler(player: Player) extends KeyAdapter {
  val log = LogFactory.getLog(getClass)

  override def keyPressed(e: KeyEvent) {
    val code = e.getKeyCode
    code match {
      case 37 => player.moveLeft
      case 38 => player.moveUp
      case 39 => player.moveRight
      case 40 => player.moveDown
      case _ => log.info("unknown keyCode: " + code)
    }
  }

}