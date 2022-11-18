`mvn install` to install plugin to C:\Users\{User}\.m2\repository\

### to use it in another project

```xml
<build>
  <plugins>
    <plugin>
      <groupId>com.rohim</groupId>
      <artifactId>rohim-maven-plugin</artifactId>
      <version>1.0</version>
    </plugin>
  </plugins>
</build>
```

and run `mvn rohim:sayhi`


### to display plugin info

`mvn help:describe -Dplugin=com.rohim:rohim-maven-plugin:1.0`