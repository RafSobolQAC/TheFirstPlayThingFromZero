package controllers

import javax.inject._
import play.api.mvc._

@Singleton
class HelloWorldController @Inject()(cc: ControllerComponents) extends AbstractController(cc)  {
  def index = Action {
    Ok("Hello World!").withHeaders(
      CACHE_CONTROL -> "max-age=3600",
      EXPIRES -> "Expires: Wed, 21 Oct 2020 07:28:00 GMT"
    )
  }

  def getHeader(header: String) = Action {implicit request: Request[AnyContent] =>
    Ok(request.headers.get(header).getOrElse("Value not found"))
  }

  def help = Action {
    Redirect("https://google.co.uk", MOVED_PERMANENTLY)
  }

  def infinite: Action[AnyContent] = Action {
    Redirect(routes.HelloWorldController.infinite())
  }
  def todoMethod = TODO
}
