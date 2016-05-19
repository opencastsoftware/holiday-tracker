package controllers

import org.scalatestplus.play.{OneAppPerSuite, PlaySpec}
import play.api.mvc.{Action, AnyContent, Result}
import play.api.test.FakeRequest
import play.api.test.Helpers._

import scala.concurrent.Future


class HolidayControllerSpec extends PlaySpec with OneAppPerSuite {

  "The Application controller" must {
    "respond with OK" when {
      "a valid GET request is made" in {
        val result: Future[Result] = HolidayController.index.apply(FakeRequest("GET", "/"))

        status(result) mustBe OK
        contentAsString(result) must include("Please enter your name")
      }
    }
  }

  "holidayRemaining" must {
    "return the number of holidays remaining" when {
      "given a valid name" in {
        HolidayController.holidayRemaining("Bob") mustBe 3
        HolidayController.holidayRemaining("Nicole") mustBe 10
      }
    }
  }

  "submit" must {
    "respond with OK" when {
      "given a name" in {
        val name = "Nicole"
        val result: Future[Result] = HolidayController.submit.apply(FakeRequest().withFormUrlEncodedBody("Name" -> name))

        status(result) mustBe OK
        contentAsString(result) must include("You have 10 days of holiday remaining!")
      }
    }
  }
}
