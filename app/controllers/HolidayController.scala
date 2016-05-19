package controllers


import play.api.data.Forms._
import play.api.data.Form
import play.api.mvc._
import views.html.{main, hellothere}
import models.HolidayData

class HolidayController extends Controller {

  val testForm = Form(
    single(
      "Name" -> text
    )
  )

  def index = Action {
    Ok(main(testForm))
  }

  def submit = Action { implicit request =>
    testForm.bindFromRequest().fold(
      formWithErrors => Ok(hellothere(1)), // should be errors here
      name => Ok(hellothere(1))
    )
  }
  
  def holidayRemaining(name: String): Int = {
    val personInfo: List[(String, Int)] = HolidayData.remainingHolidays.filter(_._1 == name)
    personInfo(0)._2
  }

}

object HolidayController extends HolidayController