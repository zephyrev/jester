name := "jester"
 
scalaVersion := "2.9.1"
 
libraryDependencies ++= Seq(
  "ch.qos.logback" % "logback-classic" % "0.9.29" % "compile->default",
  "org.specs2" %% "specs2" % "1.6.1",
  "org.specs2" %% "specs2-scalaz-core" % "6.0.1" % "test",
  "se.scalablesolutions.akka" % "akka-actor" % "1.2",
  "net.databinder" %% "dispatch-core" % "0.8.5",
  "net.databinder" %% "dispatch-oauth" % "0.8.5",
  "net.databinder" %% "dispatch-lift-json" % "0.8.5",
  "net.databinder" %% "dispatch-nio" % "0.8.5"
)

resolvers ++= Seq(	"snapshots" at "http://scala-tools.org/repo-snapshots",
					"releases"  at "http://scala-tools.org/repo-releases",
					"Typesafe Repository" at "http://repo.typesafe.com/typesafe/releases/"	)


initialCommands := "import dispatch._"
