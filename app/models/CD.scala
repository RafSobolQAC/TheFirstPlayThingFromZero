package models

import play.api.data.Form
import play.api.data.Forms._

case class CD(name: String, price: BigDecimal) {
  override def toString: String = s"The CD is $name and it costs £$price."
}
object CD {
  val createCDForm: Form[CD] = Form(
    mapping(
      "name" -> nonEmptyText,
      "price" -> bigDecimal(7,2)
    )(CD.apply)(CD.unapply)
  )
}