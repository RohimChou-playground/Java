# what does this tool do?
run maven command if any source file changed

# run the code
mvn package -T 1C -DskipTests & java -jar target\mavenwatch-1.0.jar

# parameters
now all hard coded
1. watch dir: D:\\Github\\Java\\008-Tools\\01-MavenWatch\\src\\main\\resources\\task1.bat
2. what to do if file changed: task1.bat