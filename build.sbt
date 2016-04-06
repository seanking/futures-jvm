name := """future-testing"""

version := "0.1.0"

scalaVersion := "2.11.2"

libraryDependencies ++= Seq(
  "org.scalatest" %% "scalatest" % "2.2.2" % "test",
  "junit" % "junit" % "4.12" % "test",
  "com.novocode" % "junit-interface" % "0.11" % "test",
  "org.hamcrest" % "hamcrest-all" % "1.3" % "test"
 )


fork in run := true
