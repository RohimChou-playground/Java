package com.rohim.consoleapp;

public class App {
    public static void main(String[] args) {
        // Bootstrap ClassLoader 最顶层的加载类，主要加载核心类库，%JRE_HOME%\lib下的rt.jar、resources.jar、charsets.jar和class等
        // Extention ClassLoader 扩展的类加载器，加载目录%JRE_HOME%\lib\ext目录下的jar包和class文件。
        // Appclass Loader也称为SystemAppClass 加载当前应用的classpath的所有类

        // AppClassLoader
        System.out.println(App.class.getClassLoader());
        // jar:file:/D:/Codes/Java/007-Maven/03-MinimalConsole/target/consoleapp-1.0.jar!/com/rohim/consoleapp/App.class
        System.out.println(App.class.getClassLoader().getResource("com/rohim/consoleapp/App.class"));
        // or
        System.out.println(App.class.getResource("App.class"));
        // or
        System.out.println(App.class.getResource(App.class.getSimpleName() + ".class"));

        // ExtClassLoader
        System.out.println(App.class.getClassLoader().getParent());

        // null
        // 这表明ExtClassLoader也没有父加载器。那么，为什么标题又是每一个加载器都有一个父加载器呢？这不矛盾吗？
        // 大概可以說Bootstrap ClassLoader是由C/C++编写的，它本身是虚拟机的一部分，所以它并不是一个JAVA类，也就是无法在java代码中获取它的引用
        //   ，JVM启动时通过Bootstrap类加载器加载rt.jar等核心jar包中的class文件，之前的int.class,String.class都是由它加载。
        System.out.println(App.class.getClassLoader().getParent().getParent());
    }
}
