call mvn install:install-file -Dfile=.\lib\sayhiutil-1.0.jar -DgroupId=com.rohim -DartifactId=sayhiutil -Dversion=1.0 -Dpackaging=jar -DlocalRepositoryPath=lib
call mvn install:install-file -Dfile=.\lib\sayhiutil-2.0.jar -DgroupId=com.rohim -DartifactId=sayhiutil -Dversion=2.0 -Dpackaging=jar -DlocalRepositoryPath=lib


call mvn install:install-file -Dfile=.\lib\log4a.jar -DgroupId=com.rohim -DartifactId=log4a -Dversion=1.0 -Dpackaging=jar -DlocalRepositoryPath=lib