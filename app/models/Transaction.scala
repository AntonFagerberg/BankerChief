package models

import org.joda.time.LocalDate

/** Transaction in bank account.
  *
  * @param date     Date of transaction.
  * @param value    Value of transaction.
  * @param company  Company the transaction is from / to.
  */
case class Transaction(
  date: LocalDate,
  value: Double,
  company: String
)
