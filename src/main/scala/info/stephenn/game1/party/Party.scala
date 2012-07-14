package info.stephenn.game1.party

import java.awt.Graphics
import org.apache.commons.logging.LogFactory

class Party {
  val log = LogFactory.getLog(getClass)
  val CHARACTER = "E"
  var x = 50
  var y = 50

  def draw(g: Graphics) = {
    log.info("draw")
    g.drawString(CHARACTER, x, y)
  }
}