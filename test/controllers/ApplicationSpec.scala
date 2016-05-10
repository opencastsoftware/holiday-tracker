package controllers

import org.scalatest.Matchers
import org.scalatestplus.play.PlaySpec
import play.api.mvc.{Result, AnyContent, Action}
import play.api.test.FakeRequest
import play.api.test.Helpers._

import scala.concurrent.Future


class TestApplicationSpec extends PlaySpec {

  "The Application controller" must {
    "respond to a valid GET request with OK" in {

      val result: Action[AnyContent] = TestApplication.index
      val result2: Future[Result] = result.apply(FakeRequest("GET", "/"))

      status(result2) mustBe OK
    }
  }
}
