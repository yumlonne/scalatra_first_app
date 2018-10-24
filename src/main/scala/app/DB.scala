package app

import scalikejdbc.{DB => sjDB, _}

object DB extends Config {
  val Seq(driverClass, connectString, user, pass) = configs("db.driver_class", "db.connect_string", "db.user", "db.pass")
  Class.forName(driverClass)
  ConnectionPool.singleton(connectString, user, pass)
}

trait DB {

}
