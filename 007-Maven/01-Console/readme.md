## To create a consoleapp by Maven

without the help of IDE

https://maven.apache.org/guides/getting-started/maven-in-five-minutes.html

### Steps
```bash
# make sure maven command line tool is installed in your os
mvn --version 

mvn archetype:generate -DarchetypeArtifactId=maven-archetype-quickstart -DinteractiveMode=false -DgroupId=com.foo.bar -DartifactId=myconsoleapp

cd myconsoleapp

# build the package
mvn package

# run the program
java -cp target\myconsoleapp-1.0-SNAPSHOT.jar com.foo.bar.App
```

using maven-jar-plugin to config manifest.mf
add following to pom.xml
```
<build>
  <plugins>
    <plugin>
      <groupId>org.apache.maven.plugins</groupId>
      <artifactId>maven-jar-plugin</artifactId>
      <configuration>
        <archive>
          <manifest>
            <addClasspath>true</addClasspath>
            <mainClass>com.foo.bar.App</mainClass>
          </manifest>
        </archive>
      </configuration>
    </plugin>
  </plugins>
</build>
```

```basj
# run build
mvn package

# execute java
java -jar target\myconsoleapp-1.0-SNAPSHOT.jar
```