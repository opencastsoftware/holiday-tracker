package controllers

import play.api.mvc._
import views.html.main

class TestApplication extends Controller {

  def index = Action {
    Ok(main())
  }

}

object TestApplication extends TestApplication