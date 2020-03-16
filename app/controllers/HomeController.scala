package controllers

import javax.inject._
import model.Person
import play.api.mvc._

/**
 * This controller creates an `Action` to handle HTTP requests to the
 * application's home page.
 */
@Singleton
class HomeController @Inject()(cc: ControllerComponents) extends AbstractController(cc) {

  /**
   * Create an Action to render an HTML page with a welcome message.
   * The configuration in the `routes` file means that this method
   * will be called when the application receives a `GET` request with
   * a path of `/`.
   */
  def index = Action { implicit request: Request[AnyContent] =>
    Ok(views.html.index("Hello there!")).withSession(request.session + ("connected" -> "isIndeedConnected@gmail.com"))
  }

  def okGetConnection(request: Request[AnyContent]) = Ok(request.session.get("connected").getOrElse("User is not logged in"))

  def getSession = Action{ implicit request: Request[AnyContent] =>
    okGetConnection(request)
  }

  def deleteSession = Action {implicit request: Request[AnyContent] =>
    okGetConnection(request).withSession(request.session - "connected")
  }

  def getPi = Action {implicit request: Request[AnyContent] =>
    Ok(views.html.pi())
  }

  def sendPeople = Action{implicit request: Request[AnyContent] =>
    val peopleList = List(Person("a",1),Person("b",2),Person("c",3),Person("d",4),Person("e",5),Person("f",6),Person("g",7),Person("h",8))
    Ok(views.html.people(peopleList))

  }

}
