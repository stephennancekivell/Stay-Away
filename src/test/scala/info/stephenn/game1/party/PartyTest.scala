package info.stephenn.game1.party

import org.junit.Test
import org.junit.Assert._

class PartyTest {
  
  @Test
  def whenIsNear = {
    val a = new Party()
    val b = new Party()
    
    a.x = 50
    a.y = 50
    
    b.x = 50
    b.y = 50
    
    assertTrue(a.isNear(b))
  }
  
  @Test
  def whenNotIsNear = {
    val a = new Party()
    val b = new Party()
    
    a.x = 50
    a.y = 50
    
    b.x = 81
    b.y = 81
    
    assertFalse(a.isNear(b))
  }
}