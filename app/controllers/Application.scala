/**
 * Created by Anton Fagerberg.
 * anton@antonfagerberg.com | www.antonfagerberg.com
 */
package controllers

import play.api.mvc._
import play.api.data.Forms._
import play.api.data.Form
import AuthenticatedRequest.userRequest

object Application extends Controller {
  val userForm = Form(
    tuple(
      "email" -> email,
      "password" -> nonEmptyText
    ).verifying(
      emailPassword => models.User.authenticate(emailPassword._1, emailPassword._2.toCharArray)
    )
  )

  def logout = Action { implicit request =>
    Redirect(routes.Application.index()).withNewSession.flashing("message" -> "You are signed out!")
  }

  def index = Action { implicit request =>
    Ok(views.html.login(userForm))
  }

  def login = Action { implicit request =>
    val sentForm = userForm.bindFromRequest()

    if (sentForm.hasErrors) BadRequest(views.html.login(sentForm))
    else Redirect(routes.Parse.submit()).withSession(AuthenticatedRequest.sessionField -> sentForm.get._1)
  }
}