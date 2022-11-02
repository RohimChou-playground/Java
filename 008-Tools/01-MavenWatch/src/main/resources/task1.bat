# this bat would be executed on file changed
cd D:
cd D:\Github\Java\007-Maven\01-Console\myconsoleapp
mvn package -DskipTests & echo. & java -jar target\myconsoleapp-1.0-SNAPSHOT.jar