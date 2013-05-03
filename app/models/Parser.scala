/**
 * Created by Anton Fagerberg.
 * anton@antonfagerberg.com | www.antonfagerberg.com
 */
package models

import org.joda.time.LocalDate

object Parser {
  /** Parse input data from user and build a List of Transactions from it.
    *
    * @param data Data (raw string from text area).
    * @return     Was the parsing successful.
    */
  def parse(data: String): Boolean = {
    val parserSetting = ParserSetting("\t", 2, 0, 1, Some(","))

    def buildItems(rows: List[String], items: List[Transaction] = Nil): List[Transaction] = {
      if (rows.headOption.isEmpty) items
      else {
        val rowItems = rows.head.split(parserSetting.separator)
        val date = new LocalDate(rowItems(parserSetting.dateIndex).trim)
        val company = rowItems(parserSetting.companyIndex).trim
        val value =
          if (parserSetting.decimalSeparator.isDefined)
            rowItems(parserSetting.valueIndex).replace(parserSetting.decimalSeparator.get, ".").toDouble
          else
            rowItems(parserSetting.valueIndex).toDouble

        buildItems(rows.tail, Transaction(date, value, company) :: items)
      }
    }

    println(buildItems(data.split("\n").toList))
    true
  }
}
