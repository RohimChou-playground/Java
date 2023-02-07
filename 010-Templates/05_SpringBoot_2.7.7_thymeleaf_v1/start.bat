call mvn clean package -DskipTests
rmdir target\antrun /s /q
rmdir target\classes /s /q
rmdir target\generated-sources /s /q
rmdir target\maven-archiver /s /q
rmdir target\maven-status /s /q
del target\web.jar.original /q
call mvn spring-boot:run -Dspring-boot.run.arguments="--spring.config.location='classpath:application-dev.properties'"
