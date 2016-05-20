package models

import scala.io.Source


case class remainingHoliday(name: String, daysRemaining: Int)

object HolidayData {

  def holidayRemaining(name: String): Int = {
    val personInfo: List[remainingHoliday] = HolidayData.parseHolidayCsv.filter(_.name == name)
    personInfo.head.daysRemaining
  }

  def parseHolidayCsv: List[remainingHoliday] = {

    val src = Source.fromFile("app/models/holidayCsv.csv")
    val iter: List[String] = src.getLines().toList

    iter.map { row =>
      val entry = row.split(",")
      remainingHoliday(entry(0), entry(1).toInt)
    }
  }

  lazy val allData = parseHolidayCsv

  def checkName(name: String): Boolean = {
      allData.exists {x => x.name == name}
  }
}
