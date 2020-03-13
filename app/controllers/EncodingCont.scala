package controllers

import javax.inject._
import play.api.mvc._

@Singleton
class EncodingCont @Inject()(cc: ControllerComponents) extends AbstractController(cc){
  def asText = Action { implicit request: Request[AnyContent] =>
    Ok("Hello World!").as("text/html")
  }

  def asHtml = Action { implicit request: Request[AnyContent] =>
    Ok("Hello World!").as(HTML)
  }
}
