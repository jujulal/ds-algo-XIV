organization := "com.zazzercode"

name := "compiler"

version := "1.0-SNAPSHOT"

scalaVersion := "2.10.4"

resolvers ++=Seq(
	"Typesafe Repository" at "http://repo.typesafe.com/typesafe/releases/"
	)

libraryDependencies ++= Seq(
    //"org.scala-lang" % "scala-swing" % "2.10+",
    "junit" % "junit" % "4.10",
    "org.scalatest" % "scalatest_2.10" % "2.0" % "test" //for scala
    //"com.novocode" % "junit-interface" % "0.10-M1" % "test"
)
