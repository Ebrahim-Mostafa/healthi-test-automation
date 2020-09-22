Automation Testing Framework Installation [Confluence Page](https://cegedimrx.spectrumhosting.net/confluence/display/HEAL/Automation+Testing+Framework+Installation).<br />

## `Prerequisites:`

Download and install [Java 8](https://www.oracle.com/java/technologies/javase/javase-jdk8-downloads.html).<br />

Download and install [Apache Maven](https://maven.apache.org/download.cgi).<br />

## `ATUTestRecorder Installation:`

Please run this command on your console inside or outside the IDE considering the location of the JAR file which is in the Data folder:<br />

> mvn install:install-file -Dfile={Path}\ATUTestRecorder_2.1.jar -DgroupId=org.aut.tm -DartifactId=cxf-bundle -Dversion=2.1 -Dpackaging=jar <br />

In case you have a problem with the dependency, to resolve the issue please check the dependencies in this link and follow the same tags:<br /><br />

the dependency after adding the missing tags:<br />

=========================== <br />
```xml
<dependency>
<groupId>atu.testng.reports.ATUTestRecorder</groupId>
<artifactId>ATUTestRecorder</artifactId>
<scope>system</scope> 
<version>2.1</version> 
<systemPath>${basedir}\Data\ATUTestRecorder_2.1.jar</systemPath>
</dependency>
```
============================<br />

## `MonteScreenRecorder Installation:`

Please run this command on your console inside or outside the IDE considering the location of the JAR file which is in the Data folder:<br />

> mvn install:install-file -Dfile={Path}\monte-screen-recorder-0.7.7.0.jar -DgroupId=com.github.stephenc.monte -DartifactId=monte-screen-recorder -Dversion=0.7.7.0 -Dpackaging=jar -DgeneratePom=true <br />

## `Install Allure to generate reports:`

Open your windows PowerShell:<br />

One of the easiest way to start PowerShell in Windows is using Run window. Press Win + R keys on your keyboard, then type PowerShell and press Enter or click OK.<br />

Run these Commands:<br />

> Set-ExecutionPolicy RemoteSigned -scope CurrentUser <br />

> iex (new-object net.webclient).downloadstring('https://get.scoop.sh') <br />

In the above case, it was already installed, so you a message as 'Scoop is already installed'. You can run 'scoop update' to get the latest version any time, To install Allure, using Scoop, run the below command:<br />

> scoop install allure <br />