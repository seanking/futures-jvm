name := """future-testing"""

version := "0.1.0"

scalaVersion := "2.11.2"

// ScalaTest
libraryDependencies += "org.scalatest" %% "scalatest" % "2.2.2" % "test"

libraryDependencies += "junit" % "junit" % "4.11" % "test"

libraryDependencies += "org.hamcrest" % "hamcrest-all" % "1.3" % "test"


fork in run := true