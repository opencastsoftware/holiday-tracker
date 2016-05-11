package controllers

import play.api.mvc._
import views.html.main
import models.HolidayData

class HolidayController extends Controller {

  def index = Action {
    Ok(main())
  }

  val test = HolidayData

  def holidayRemaining(name: String): Int = {
    val personInfo: List[(String, Int)] = HolidayData.remainingHolidays.filter(_._1 == name)
    personInfo(0)._2
  }

}

object HolidayController extends HolidayController