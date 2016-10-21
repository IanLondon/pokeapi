lazy val commonSettings = Seq(
  organization := "com.github.ianlondon",
  version := "0.1.0",
  scalaVersion := "2.11.8"
)

lazy val root = (project in file(".")).
  enablePlugins(ConscriptPlugin).
  settings(commonSettings: _*).
  settings(
    name := "pokeapi",
    libraryDependencies += "io.argonaut" %% "argonaut" % "6.1",
    libraryDependencies += "org.scalatest" %% "scalatest" % "3.0.0" % "test",
    libraryDependencies += "org.scalaj" %% "scalaj-http" % "2.3.0"
  )
