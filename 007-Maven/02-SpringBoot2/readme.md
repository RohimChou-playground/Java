## To create a consoleapp by spring-cli

without the help of IDE

### Steps
```bash
# make sure maven and spring-cli command line tool is installed in your os
mvn --version 
spring --version

# check available init options
spring init --list

# create project skeleton
spring init --build=maven -java-version=1.8 --dependencies=web --group-id=com.foo --artifact-id=myspringboot --packaging=war myspringboot

cd myspringboot
```

create controllers/TestController.java
```java
package com.foo.myspringboot.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("test")
public class TestController {
	
	@RequestMapping(path = "t1", method = RequestMethod.GET)
	@ResponseBody
	public Object t1() {
		return "Hello World";
	}
}
```


```bash
# clean & build
mvn clean package

# run the app
java -jar target\myspringboot-0.0.1-SNAPSHOT.jar

# browser open http://localhost:8080/test/t1 to see the result
```