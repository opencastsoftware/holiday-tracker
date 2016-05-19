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

  val test = HolidayData

  def submit = Action { implicit request =>
    testForm.bindFromRequest().fold(
      formWithErrors => BadRequest(main(testForm)), // should be errors here.
      name => Ok(hellothere(holidayRemaining(name)))
    )
  }

  def holidayRemaining(name: String): Int = {
    val personInfo: List[(String, Int)] = HolidayData.remainingHolidays.filter(_._1 == name)
    personInfo.head._2
  }

}

object HolidayController extends HolidayController