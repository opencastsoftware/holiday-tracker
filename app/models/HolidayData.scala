package models

import scala.io.Source


object HolidayData {


  def holidayRemaining(name: String): Int = {
    val personInfo: List[(String, Int)] = HolidayData.parseHolidayCsv.filter(_._1 == name)
    personInfo.head._2
  }

  def parseHolidayCsv: List[(String, Int)] = {

    val src = Source.fromFile("app/models/holidayCsv.csv")
    val iter: List[String] = src.getLines().toList

    iter.map { row =>
      val entry = row.split(",")
      (entry(0), entry(1).toInt)
    }
  }
}
