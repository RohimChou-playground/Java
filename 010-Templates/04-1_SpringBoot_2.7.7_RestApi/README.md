# create project skeleton by
```
spring init --build=maven  -java-version=1.8 --bootVersion=2.7.7 --dependencies=web --group-id=com.rohim --artifact-id=web --packaging=jar -x .

# -x . means extract to current folder

del mvnw mvnw.cmd HELP.md .gitignore
rmdir .mvn /s /q & rmdir src\test /s /q & rmdir src\main\resources\templates /s /q 
```

# modify pom.xml
```
<version>0.0.1-SNAPSHOT</version> -> <version>1.0</version>
<name>demo</name> -> <name>web</name>
remove <description>Demo project for Spring Boot</description>
```
<properties/> 改成
```
<properties>
    <!-- 
        without this, will receive these warnings:
        [WARNING] Using platform
            encoding (MS950 actually) to copy filtered resources, i.e. build is platform dependent!
        [WARNING] File encoding has not been set, using platform encoding MS950, i.e. build is
            platform dependent!
    -->
    <project.build.sourceEncoding>UTF-8</project.build.sourceEncoding>
    <java.version>1.8</java.version>
    <!-- 
        without this, will receive these errors when annotate implements method with @Override:
        method xxx of type xxx must override a superclass method
    -->
    <maven.compiler.source>1.8</maven.compiler.source>
    <maven.compiler.target>1.8</maven.compiler.target>
</properties>
```
depndency加一個
```
<!-- for hot reload capability in development process -->
<dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-devtools</artifactId>
    <!-- version 2.7.7 (from parent)  -->
    <optional>true</optional>
</dependency>
```
build區域改成
```
<build>
    <!-- final jar name -->
    <finalName>web</finalName>
    <plugins>
        <plugin>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-maven-plugin</artifactId>
        </plugin>
        <!-- for copy, clean up files of the build folder (/target) -->
        <plugin>
            <groupId>org.apache.maven.plugins</groupId>
            <artifactId>maven-antrun-plugin</artifactId>
            <version>1.8</version>
            <executions>
                <execution>
                    <?m2e execute onConfiguration, onIncremental?> <!-- for muting warning of eclipse's m2e plugin -->
                    <phase>process-resources</phase>
                    <configuration>
                        <tasks>
                            <copy todir="${build.directory}"
                                file="${basedir}/src/main/resources/application.properties" />                               
                            <copy todir="${build.directory}"
                                file="${basedir}/src/main/resources/application-dev.properties" />
                            <copy todir="${build.directory}" file="${basedir}/README.md" />
                        </tasks>
                    </configuration>
                    <goals>
                        <goal>run</goal>
                    </goals>
                </execution>
            </executions>
        </plugin>
    </plugins>
</build>
```

# src/main/resources 底下新增 application-dev properties
```
server.port=8088
```

# DemoApplication.java 改名為 ApplicationStart.java

# main/java/com/rohim/web 下新增 controller 資料夾及 HomeController.java
```
package com.rohim.web.controllers;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping(path="/")
public class HomeController {

    @RequestMapping(path="/", method=RequestMethod.GET)
    public ModelAndView index(
        HttpServletRequest request, 
        HttpServletResponse response, 
        HttpSession session) {
        
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("index");
        modelAndView.addObject("userName", "John");
		return modelAndView;
	}

    @RequestMapping(path="/numbers", method=RequestMethod.GET)
    @ResponseBody
	public int[] numbers() {
		return new int[] {1, 2, 3, 4, 5};
	}
}
```

resrouce/static 底下新增 index.html
```
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>web</title>
</head>
<body>
    Hello World!
</body>
</html>
```


# build this project
```
call mvn clean package -DskipTests
rmdir target\antrun /s /q
rmdir target\classes /s /q
rmdir target\generated-sources /s /q
rmdir target\maven-archiver /s /q
rmdir target\maven-status /s /q
del target\web.jar.original /q
```

# run this project locally
```
這種可以開發時用，有hotreload
mvn spring-boot:run -Dspring-boot.run.arguments="--spring.config.location='classpath:application-dev.properties'"

這種可以部屬時用，沒有hotreload
java -Dspring.config.location=target\application-dev.properties -jar target\web.jar
```