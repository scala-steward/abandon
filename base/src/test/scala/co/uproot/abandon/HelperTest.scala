package co.uproot.abandon

import org.scalatest.flatspec.AnyFlatSpec
import org.scalatest.matchers.should.Matchers

class HelperTest extends AnyFlatSpec with Matchers {

  "Helper" should "get month numbers for valid full month names" in {
    Helper.getMonthNumber("January") should be(Some(1))
    Helper.getMonthNumber("February") should be(Some(2))
    Helper.getMonthNumber("March") should be(Some(3))
    Helper.getMonthNumber("April") should be(Some(4))
    Helper.getMonthNumber("May") should be(Some(5))
    Helper.getMonthNumber("June") should be(Some(6))
    Helper.getMonthNumber("July") should be(Some(7))
    Helper.getMonthNumber("August") should be(Some(8))
    Helper.getMonthNumber("September") should be(Some(9))
    Helper.getMonthNumber("October") should be(Some(10))
    Helper.getMonthNumber("November") should be(Some(11))
    Helper.getMonthNumber("December") should be(Some(12))
  }

  it should "get month numbers for valid short month names" in {
    Helper.getMonthNumber("Jan") should be(Some(1))
    Helper.getMonthNumber("Feb") should be(Some(2))
    Helper.getMonthNumber("Mar") should be(Some(3))
    Helper.getMonthNumber("Apr") should be(Some(4))
    Helper.getMonthNumber("May") should be(Some(5))
    Helper.getMonthNumber("Jun") should be(Some(6))
    Helper.getMonthNumber("Jul") should be(Some(7))
    Helper.getMonthNumber("Aug") should be(Some(8))
    Helper.getMonthNumber("Sep") should be(Some(9))
    Helper.getMonthNumber("Oct") should be(Some(10))
    Helper.getMonthNumber("Nov") should be(Some(11))
    Helper.getMonthNumber("Dec") should be(Some(12))
  }

  it should "handle case insensitivity correctly" in {
    Helper.getMonthNumber("JANUARY") should be(Some(1))
    Helper.getMonthNumber("jan") should be(Some(1))
    Helper.getMonthNumber("mArCh") should be(Some(3))
    Helper.getMonthNumber("aUg") should be(Some(8))
  }

  it should "return None for invalid month names" in {
    Helper.getMonthNumber("foo") should be(None)
    Helper.getMonthNumber("Janu") should be(None)
    Helper.getMonthNumber("") should be(None)
  }

}
