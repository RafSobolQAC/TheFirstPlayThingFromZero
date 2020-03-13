package controllers

import javax.inject._
import play.api.mvc._

@Singleton
class CookiesCont @Inject()(cc: ControllerComponents) extends AbstractController(cc) {

  def makeCookie = Action { implicit request: Request[AnyContent] =>
    Ok("Baking cookies!").withCookies(
      Cookie("isDone", "baked")
    )
  }

  def getCookie = Action { implicit request: Request[AnyContent] =>
    Ok(request.cookies
      .get("isDone") match {
      case None => ""
      case Some(cookie) => cookie.value
    }
    )
  }

  def eatCookie = Action { implicit request: Request[AnyContent] =>

    Ok("Eaten "+
      request.cookies
      .get("isDone") match {
      case None => ""
      case Some(cookie) => cookie.value
    }
    ).discardingCookies(
      DiscardingCookie("isDone")
    )
  }
}
