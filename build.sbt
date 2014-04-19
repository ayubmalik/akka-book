name := "akka-book"

version := "1.0"

scalaVersion := "2.10.2"

libraryDependencies ++= Seq(
  "org.scalatest" % "scalatest_2.10" % "2.0",
  "junit" % "junit" % "4.11",
  "com.typesafe.akka" %% "akka-actor" % "2.2.1",
  "com.typesafe.akka" %% "akka-slf4j" % "2.2.1",
  "ch.qos.logback" % "logback-classic" % "1.0.13"
)
