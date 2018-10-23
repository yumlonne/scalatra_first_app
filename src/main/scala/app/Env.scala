package app

trait Env {
  lazy val mode: String        = sys.env("MODE")
  lazy val is_develop: Boolean = sys.env("MODE") == "develop"
  lazy val is_product: Boolean = sys.env("MODE") == "product"
}
