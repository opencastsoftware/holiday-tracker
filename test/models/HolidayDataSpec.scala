package controllers

import models.{remainingHoliday, HolidayData}
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

  "parseHolidayCsv" must {
    "return all the data from the csv file" in {
      HolidayData.parseHolidayCsv mustBe List(
        remainingHoliday("Nicole",10),
        remainingHoliday("Bob",3),
        remainingHoliday("Darwin",12),
        remainingHoliday("Elfriede",16),
        remainingHoliday("Candace",19),
        remainingHoliday("Estela",4),
        remainingHoliday("Marty",6),
        remainingHoliday("Bonnie",8),
        remainingHoliday("Dewey",23),
        remainingHoliday("Corrie",21),
        remainingHoliday("Lora",15),
        remainingHoliday("Brianne",3))
    }
  }

  "checkName" must {
    "return true" when {
      "given a name which is in the data" in {
        HolidayData.checkName("Nicole") mustBe true
      }
    }
    "return false" when {
      "given a name which is not in the data" in {
        HolidayData.checkName("NoName") mustBe false
      }
    }
  }
}
