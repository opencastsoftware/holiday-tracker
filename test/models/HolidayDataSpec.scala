package controllers

import models.HolidayData
import org.scalatestplus.play.{OneAppPerSuite, PlaySpec}


class HolidayDataSpec extends PlaySpec with OneAppPerSuite {

  "holidayRemaining" must {
    "return the number of holidays remaining" when {
      "given a valid name" in {
        HolidayData.holidayRemaining("Bob") mustBe 3
        HolidayData.holidayRemaining("Nicole") mustBe 10
      }
    }
  }
}
