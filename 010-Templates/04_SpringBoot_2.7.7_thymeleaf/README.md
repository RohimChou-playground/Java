# create project skeleton by
```
spring init --build=maven  -java-version=1.8 --bootVersion=2.7.7 --dependencies=web --group-id=com.rohim --artifact-id=web --packaging=jar -x .

# -x . means extract to current folder

del mvnw mvnw.cmd HELP.md .gitignore
rmdir .mvn /s /q & rmdir src\test /s /q & rmdir src\main\resources\templates /s /q 
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
mvn spring-boot:run -Dspring-boot.run.arguments="--spring.config.location='classpath:application-dev.properties'"
```