package controllers


import play.api.data.Forms._
import play.api.data.Form
import play.api.data.validation.{Valid, Constraint}
import play.api.mvc._
import views.html.{main, hellothere}
import models.HolidayData

class HolidayController extends Controller {

  val testForm = Form(
    single("Name" -> nonEmptyText.verifying(x => HolidayData.checkName(x)))
  )

  def index = Action {
    Ok(main(testForm))
  }

  def submit = Action { implicit request =>
    testForm.bindFromRequest().fold(
      (formWithErrors: Form[String]) => BadRequest(main(formWithErrors)),
      name => Ok(hellothere(HolidayData.holidayRemaining(name)))
    )
  }
}

object HolidayController extends HolidayController
