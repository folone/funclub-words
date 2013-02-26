name := "simplewords"

version := "0.1"

scalaVersion := "2.10.0"

libraryDependencies ++= Seq(
  "org.scalaz"  %% "scalaz-core"   % "7.0.0-M8",
  "org.scalaz"  %% "scalaz-effect" % "7.0.0-M8",
  "machines"    %% "machines"      % "0.1-SNAPSHOT"
)
