package controllers

import javax.inject._
import play.api.mvc._

@Singleton
class FlashController @Inject()(cc: ControllerComponents) extends AbstractController(cc) {
  def read() = Action{ implicit request: Request[AnyContent] =>
    Ok(views.html.flashthing())
  }

  def write() = Action{implicit request: Request[AnyContent] =>
    Redirect("/flash/read").flashing("success" -> "Success redirecting!")
  }
}
