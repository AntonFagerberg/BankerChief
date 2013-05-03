/**
 * Created by Anton Fagerberg.
 * anton@antonfagerberg.com | www.antonfagerberg.com
 */
package models

/** Settings to apply in parsing.
  *
  * @param separator        Field separator.
  * @param dateIndex        Index of Date field.
  * @param valueIndex       Index of Value field.
  * @param companyIndex     Index of Company field.
  * @param decimalSeparator If decimal value is separated by other char than '.', specify it here.
  */
case class ParserSetting(
  separator: String,
  dateIndex: Int,
  valueIndex: Int,
  companyIndex: Int,
  decimalSeparator: Option[String] = None
)
