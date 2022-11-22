this is the minimal maven java console app setup
create by manually adding the folder & files


# register local .jar lob project/localrepo
only need once
```
mvn install:install-file -Dfile=src\main\resources\lib\utils-1.0.jar ^
                         -DgroupId=com.rohim                         ^
                         -DartifactId=utils                          ^
                         -Dversion=1.0                               ^
                         -Dpackaging=jar                             ^
                         -DlocalRepositoryPath=localrepo
```

to build & run it
```
mvn clean package & java -jar target\consoleapp-1.0.jar
```
