package controllers


import play.api.data.Forms._
import play.api.data.Form
import play.api.mvc._
import views.html.{main, hellothere}
import models.HolidayData

class HolidayController extends Controller {

  val form = Form(
    tuple(
      "firstname" -> text,
      "lastname" -> text
    )
  )

  def index = Action {
    Ok(main(form))
  }

  val test = HolidayData

  def submit = Action { implicit request =>
    val (fname, lname) = form.bindFromRequest.get
    Ok("Hi %s %s".format(fname, lname))
  }

  def sayHello = Action {
    Ok(hellothere())
  }

  def holidayRemaining(name: String): Int = {
    val personInfo: List[(String, Int)] = HolidayData.remainingHolidays.filter(_._1 == name)
    personInfo(0)._2
  }

}

object HolidayController extends HolidayController