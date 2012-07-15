package info.stephenn.game1.party

import org.junit.Test
import org.junit.Assert._

class PartyTest {
  
  @Test
  def whenIsNear = {
    val a = new Party(50,50)
    val b = new Party(50,50)
    
    assertTrue(a.isNear(b))
  }
  
  @Test
  def whenNotIsNear = {
    val a = new Party(50,50)
    val b = new Party(81,81)
    
    assertFalse(a.isNear(b))
  }
}