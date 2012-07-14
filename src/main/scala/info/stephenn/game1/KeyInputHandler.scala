package info.stephenn.game1

import java.awt.event.KeyAdapter
import java.awt.event.KeyEvent
import org.apache.commons.logging._

class KeyInputHandler extends KeyAdapter {
  val log = LogFactory.getLog(getClass)
  
  override def keyPressed(e: KeyEvent) {
    val code = e.getKeyCode
    code match {
      case 37 => log.info("left")
      case 38 => log.info("up")
      case 39 => log.info("right")
      case 40 => log.info("down")
      case _ => log.info("unknown keyCode: "+code)
    }
  }

}