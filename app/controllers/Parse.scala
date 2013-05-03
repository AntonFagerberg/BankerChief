/**
 * Created by Anton Fagerberg.
 * anton@antonfagerberg.com | www.antonfagerberg.com
 */
package controllers

import play.api.mvc._
import play.api.data.Forms._
import play.api.data.Form
import AuthenticatedRequest.userRequest

object Parse extends Controller {
  def submit = userRequest() { implicit request =>
    Ok(views.html.parse())
  }
}
