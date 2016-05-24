package controllers

import org.scalatestplus.play.{OneAppPerSuite, PlaySpec}
import play.api.mvc.Result
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

  "submit" must {
    "respond with OK" when {
      "given a name" in {
        val name = "Nicole"
        val result: Future[Result] = HolidayController.submit.apply(FakeRequest().withFormUrlEncodedBody("Name" -> name))

        status(result) mustBe OK
        contentAsString(result) must include("You have 10 days of holiday remaining!")
      }
    }
    "respond with BAD_REQUEST" when {
      "given no name" in {
        val result: Future[Result] = HolidayController.submit.apply(FakeRequest().withFormUrlEncodedBody("Name" -> ""))

        status(result) mustBe BAD_REQUEST
        contentAsString(result) must include("Required")
      }
      "given the name of someone who is not on the list" in {
        val result: Future[Result] = HolidayController.submit.apply(FakeRequest().withFormUrlEncodedBody("Name" -> ""))

        status(result) mustBe BAD_REQUEST
        contentAsString(result) must include("Required")
        contentAsString(result) must not include "Not an employee"
      }
    }
  }
}
