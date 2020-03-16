package controllers

import javax.inject._
import play.api.mvc._

@Singleton
class TwirlTutCont @Inject()(cc: ControllerComponents) extends AbstractController(cc) {
  def nameAndAge(name: String, age: Int) = Action {implicit request: Request[AnyContent] =>
    Ok(views.html.twirltut(name,age))
  }

  def twoNums(num1: Int, num2: Int) = Action {implicit request: Request[AnyContent] =>
    Ok(views.html.twirttut2(num1, num2))
  }
}
