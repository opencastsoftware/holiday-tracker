name := "play-scala"

version := "1.0-SNAPSHOT"

lazy val scoverageSettings = {
  import scoverage._

  val ScoverageExclusionPatterns = List(
    "<empty>",
    "app.*",
    "views.*",
    "router.*"
  )

  Seq(
    ScoverageKeys.coverageExcludedPackages := ScoverageExclusionPatterns.mkString("",";",""),
    ScoverageKeys.coverageMinimum := 98,
    ScoverageKeys.coverageFailOnMinimum := true,
    ScoverageKeys.coverageHighlighting := true
  )
}

lazy val root = (project in file(".")).enablePlugins(PlayScala).settings(scoverageSettings : _*)

scalaVersion := "2.11.6"

libraryDependencies ++= Seq(
  jdbc,
  cache,
  ws,
  specs2 % Test,
  "org.scalatest" %% "scalatest" % "2.2.1" % "test",
  "org.scalatestplus" %% "play" % "1.4.0-M3" % "test",
  "org.reactivemongo" %% "play2-reactivemongo" % "0.11.11"
)

resolvers += "scalaz-bintray" at "http://dl.bintray.com/scalaz/releases"


// Play provides two styles of routers, one expects its actions to be injected, the
// other, legacy style, accesses its actions statically.
routesGenerator := InjectedRoutesGenerator

