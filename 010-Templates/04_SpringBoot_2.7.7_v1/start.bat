@REM for hot reload
@REM mvn spring-boot:run -Dspring-boot.run.arguments="--spring.config.location='classpath:application-dev.properties'"

@REM for deployment
call mvn clean package -DskipTests
rmdir target\antrun /s /q
rmdir target\classes /s /q
rmdir target\generated-sources /s /q
rmdir target\maven-archiver /s /q
rmdir target\maven-status /s /q
del target\web.jar.original /q

java -Dspring.config.location=target\application-dev.properties -jar target\web.jar

@REM for specify custom main class
@REM java -Dspring.config.location=target\application-dev.properties -Dloader.main=com.rohim.web.ApplicationStart org.springframework.boot.loader.PropertiesLauncher