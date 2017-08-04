name := "Database-Comparison-Tool"

version := "1.0"

scalaVersion := "2.12.1"

libraryDependencies += "mysql" % "mysql-connector-java" % "6.0.6"

libraryDependencies += "postgresql" % "postgresql" % "9.1-901-1.jdbc4"

libraryDependencies += "org.xerial" % "sqlite-jdbc" % "3.19.3"

libraryDependencies += "log4j" % "log4j" % "1.2.17"

libraryDependencies += "org.scalatest" % "scalatest_2.12" % "3.0.3" % "test"

coverageEnabled := true