package models


object HolidayData {

  val remainingHolidays = List(("Bob", 3), ("Nicole", 10))

  def holidayRemaining(name: String): Int = {
    val personInfo: List[(String, Int)] = HolidayData.remainingHolidays.filter(_._1 == name)
    personInfo.head._2
  }

}
