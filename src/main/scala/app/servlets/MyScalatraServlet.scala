package app.servlets

import org.scalatra._
import app._

class MyScalatraServlet extends ScalatraServlet {

  get("/") {
    views.html.hello()
  }

  get("/greet") {
    views.html.hello()
  }

}
