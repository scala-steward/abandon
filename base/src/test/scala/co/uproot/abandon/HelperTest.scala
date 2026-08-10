package co.uproot.abandon

import org.scalatest.flatspec.AnyFlatSpec
import org.scalatest.matchers.should.Matchers

class HelperTest extends AnyFlatSpec with Matchers {

  "allUnique" should "return None for empty collections" in {
    Helper.allUnique(Seq.empty[Int]) shouldBe None
    Helper.allUnique(List.empty[String]) shouldBe None
  }

  it should "return None for collections with all unique elements" in {
    Helper.allUnique(Seq(1, 2, 3, 4, 5)) shouldBe None
    Helper.allUnique(List("a", "b", "c")) shouldBe None
    Helper.allUnique(Set(1, 2, 3)) shouldBe None
    Helper.allUnique(Iterator(1, 2, 3, 4)) shouldBe None
  }

  it should "return Some(element) for collections with duplicate elements" in {
    Helper.allUnique(Seq(1, 2, 3, 2, 4)) shouldBe Some(2)
    Helper.allUnique(List("a", "b", "c", "a")) shouldBe Some("a")
    Helper.allUnique(Iterator(1, 2, 1, 3)) shouldBe Some(1)
  }

  it should "return the first non-unique element" in {
    Helper.allUnique(Seq(1, 2, 3, 2, 4, 3)) shouldBe Some(2)
    Helper.allUnique(List("a", "b", "c", "b", "a")) shouldBe Some("b")
  }
}
