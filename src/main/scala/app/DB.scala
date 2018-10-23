package app

import scalikejdbc.{DB => sjDB, _}

object DB extends Config {
  Class.forName(config("db.driver_class"))
  ConnectionPool.singleton(config("db.connect_string"), config("db.user"), config("db.pass"))
}

trait DB {

}
