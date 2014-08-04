[![Build Status](https://travis-ci.org/earldouglas/scala-ci.svg?branch=master)](https://travis-ci.org/earldouglas/scala-ci)
[![Coverage Status](https://coveralls.io/repos/earldouglas/scala-ci/badge.png)](https://coveralls.io/r/earldouglas/scala-ci)

# Continuous integration for Scala

*March 25, 2014*

Here I outline the steps to take to enable continuous integration for Scala 
projects, including GitHub push-triggered building and testing, code test 
coverage, stats tracking, reporting, and badging.

## Travis CI

First, enable basic continuous integration through [Travis CI](https://travis-ci.org/).

Under your [travis-ci.org profile](https://travis-ci.org/profile), find your 
project and enable it:

![Enable your project on travis-ci.org](https://raw.github.com/earldouglas/scala-ci/master/readme/travis-ci.png)

Create a *.travis.yml* file in the root of your project:

```yaml
language: scala
scala:
  - 2.11.2
```

This gives you GitHub [push-triggered builds](https://travis-ci.org/earldouglas/scala-ci) 
(which run via `sbt test`) of your project, plus a sweet [status badge](https://travis-ci.org/sbt/sbt-digest.svg?branch=master). 

## Scoverage

Next, add code coverage support to your project with [sbt-scoverage](https://github.com/scoverage/sbt-scoverage).

Import the sbt-scoverage plugin in your project configuration:

*project/plugins.sbt:*

```scala
addSbtPlugin("org.scoverage" %% "sbt-scoverage" % "0.99.7.1")
```

Enable the sbt-scoverage plugin in your build configuration:

*build.sbt:*

```scala
ScoverageSbtPlugin.instrumentSettings
```

You can now run `sbt scoverage:test` from to get nice code coverage reports.

## Coveralls

Now that you have triggered builds and code coverage, you can integrate with 
[Coveralls](http://coveralls.io/) to get integrated code coverage history and 
stats.

Head to the [add repo](http://coveralls.io/repos/new) section of Coveralls, find 
your project, and enable it:

![Enable your project on coveralls.io](https://raw.github.com/earldouglas/scala-ci/master/readme/coveralls.png)

Append `script: "sbt coveralls"` to your Travis CI configuration file:

*.travis.yml:*

```
language: scala
scala:
  - 2.10.3
script: "sbt coveralls"
```

Import the sbt-coveralls plugin in your project configuration:

*project/plugins.sbt:*

```scala
addSbtPlugin("com.sksamuel.scoverage" %% "sbt-coveralls" % "0.0.5")
```

Enable the sbt-coveralls plugin in your build configuration:

*build.sbt:*

```scala
CoverallsPlugin.coverallsSettings
```

This gives you coverage integration, plus a second [status badge](https://s3.amazonaws.com/assets.coveralls.io/badges/coveralls_82.png).
