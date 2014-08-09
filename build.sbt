scalaVersion := "2.11.2"

libraryDependencies += "org.scalaz" %% "scalaz-core" % "7.0.6"

libraryDependencies += "org.scalatest" %% "scalatest" % "2.2.0" % "test"

instrumentSettings

CoverallsPlugin.coverallsSettings
