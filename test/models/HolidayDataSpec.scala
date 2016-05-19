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

  "parseHolidayCsv" must {
    "return all the data from the csv file" in {
      HolidayData.parseHolidayCsv mustBe List(
        ("Nicole",10),
        ("Bob",3),
        ("Darwin",12),
        ("Elfriede",16),
        ("Candace",19),
        ("Estela",4),
        ("Marty",6),
        ("Bonnie",8),
        ("Dewey",23),
        ("Corrie",21),
        ("Lora",15),
        ("Brianne",3)
      )
    }
  }
}
