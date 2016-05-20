package controllers


import play.api.data.Forms._
import play.api.data.Form
import play.api.data.validation.{Invalid, ValidationError, Valid, Constraint}
import play.api.mvc._
import views.html.{main, hellothere}
import models.HolidayData

class HolidayController extends Controller {

  val nameConstraint : Constraint[String] = Constraint {field:String =>
    field match {
      case "" => Invalid("Required")
      case x: String if !HolidayData.checkName(x) => Invalid("Not an employee")
      case _ => Valid
    }
  }
  val testForm = Form(
    single("Name" -> text.verifying(nameConstraint))
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
