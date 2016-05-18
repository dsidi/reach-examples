name := "reach-examples"

version := "0.1"

scalaVersion := "2.11.6"

resolvers += "BioPAX" at "http://www.biopax.org/m2repo/releases"

libraryDependencies ++= Seq(
  "org.clulab" %% "reach" % "1.1.3"
)
