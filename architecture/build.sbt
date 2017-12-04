name := "architecture"

version := "1.0"

scalaVersion := "2.12.4"

val scalazVersion = "7.2.17"
val scalaTestVersion = "3.0.4"

libraryDependencies ++= Seq(
  "org.scalaz" %% "scalaz-core" % scalazVersion,
  "org.scalaz" %% "scalaz-effect" % scalazVersion,
  "org.scalaz" %% "scalaz-typelevel" % "7.1.15",

  //test
  "org.scalaz" %% "scalaz-scalacheck-binding" % scalazVersion % "test",
  "org.scalactic" %% "scalactic" % scalaTestVersion,
  "org.scalatest" %% "scalatest" % scalaTestVersion % "test"
)

resolvers += "Artima Maven Repository" at "http://repo.artima.com/releases"