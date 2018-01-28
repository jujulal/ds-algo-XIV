organization := "com.algo"

name := "data-structures"

version := "1.0"

scalaVersion := "2.12.3"

val scalazVersion = "7.2.18"

libraryDependencies ++= Seq(

  "org.scalaz" %% "scalaz-core" % scalazVersion,
  "org.scalaz" %% "scalaz-effect" % scalazVersion,
  "org.scalaz" %% "scalaz-typelevel" % "7.1.16",

  "org.scalactic" %% "scalactic" % "3.0.4",
  "io.spray" %%  "spray-json" % "1.3.3",

  "org.scalatest" %% "scalatest" % "3.0.4" % "test",
  "org.scalaz" %% "scalaz-scalacheck-binding" % scalazVersion % "test"
)

resolvers += "Artima Maven Repository" at "http://repo.artima.com/releases"