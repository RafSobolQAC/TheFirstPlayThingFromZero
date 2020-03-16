package controllers

import javax.inject._
import play.api.libs.json.JsValue
import play.api.mvc._

@Singleton
class BodyParserCont @Inject()(cc: ControllerComponents) extends AbstractController(cc) {
  def send = Action { implicit request: Request[AnyContent] =>
    request.body.asJson.map { json =>
      Ok("Person: " + (json \ "name").as[String] + " Age: " + (json \ "age").as[Int])
    }.getOrElse {
      BadRequest("Name and/or age not provided!")
    }
  }

  def sendJson = Action(parse.json) { implicit request: Request[JsValue] =>
    Ok("Person: " + (request.body \ "name").as[String] + " Age: " + (request.body \ "age").as[Int])

  }
}
