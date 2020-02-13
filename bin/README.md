# Project description

Simple template for projects that make use of JavaFX and FXML (Scene Builder).
Requires Java 11 or later. Compatible with
Eclipse and IntelliJ IDEA. Minor issues with Netbeans. Automatically
integrates with Gitlab CI.

## Installation

Maven:

```bash
$ git clone https://gitlab.utu.fi/tech/education/gui/template-javafx

$ cd template-javafx

$ mvn compile exec:java
```

SBT:

```bash
$ git clone https://gitlab.utu.fi/tech/education/gui/template-javafx

$ cd template-javafx

$ sbt compile run
```

## Further instructions

  * Java platform: https://gitlab.utu.fi/soft/ftdev/wikis/tutorials/jvm-platform
  * Maven: https://gitlab.utu.fi/soft/ftdev/wikis/tutorials/maven-misc
  * SBT: https://gitlab.utu.fi/soft/ftdev/wikis/tutorials/sbt-misc
  
External sources:

  * JavaFX: https://openjfx.io/javadoc/11/
  * Scene Builder: https://docs.gluonhq.com/scenebuilder/
