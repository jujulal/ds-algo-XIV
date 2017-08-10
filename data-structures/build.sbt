organization := "com.algo"

name := "data-structures"

version := "1.0-SNAPSHOT"

scalaVersion := "2.11.7"

val scalazVersion = "7.1.0"

libraryDependencies ++= Seq(
  "org.scalaz" %% "scalaz-core" % scalazVersion,
  "org.scalaz" %% "scalaz-effect" % scalazVersion,
  "org.scalaz" %% "scalaz-typelevel" % scalazVersion,
  "org.scalactic" %% "scalactic" % "2.2.6",
  "io.spray" %%  "spray-json" % "1.3.3",
  "org.scalatest" %% "scalatest" % "2.2.6" % "test",
  "org.scalaz" %% "scalaz-scalacheck-binding" % scalazVersion % "test"
)

resolvers += "Artima Maven Repository" at "http://repo.artima.com/releases"