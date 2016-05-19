package controllers


import play.api.data.Forms._
import play.api.data.Form
import play.api.mvc._
import views.html.{main, hellothere}
import models.HolidayData

class HolidayController extends Controller {

  val testForm = Form(
    single(
      "Name" -> nonEmptyText
    )
  )

  def index = Action {
    Ok(main(testForm))
  }

  def submit = Action { implicit request =>
    testForm.bindFromRequest().fold(
      formWithErrors => BadRequest(main(testForm)), // should be errors here.
      name => Ok(hellothere(HolidayData.holidayRemaining(name)))
    )
  }
}

object HolidayController extends HolidayController