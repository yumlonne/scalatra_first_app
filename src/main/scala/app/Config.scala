package app

import scala.xml.{XML, NodeSeq}

object Config extends Env {
  lazy val xml: NodeSeq = XML.loadFile("config.xml") \ mode
}

trait Config {
  def config(path: String): String = accessToXML(path, Config.xml).get
  def configs(paths: String*): Seq[String] = paths.map { path => accessToXML(path, Config.xml).get }

  def configOpt(path: String): Option[String] = accessToXML(path, Config.xml)
  def configOpts(paths: String*): Seq[Option[String]] = paths.map { path => accessToXML(path, Config.xml) }

  private def accessToXML(path: String, xml: NodeSeq): Option[String] = {
    def access(keys: List[String], xml: NodeSeq): Option[String] = keys match {
      case Nil      => None
      case x :: Nil => Some((xml \ x).text)
      case x :: xs  => access(xs, xml \\ x)
    }
    println(Config.xml.toString)
    val keys = path.split('.').toList
    println(keys.toString)
    access(keys, xml)
  }
}
