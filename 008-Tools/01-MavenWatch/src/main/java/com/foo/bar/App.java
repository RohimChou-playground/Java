package com.foo.bar;

import static com.sun.nio.file.ExtendedWatchEventModifier.FILE_TREE;
import static java.nio.file.StandardWatchEventKinds.ENTRY_CREATE;
import static java.nio.file.StandardWatchEventKinds.ENTRY_DELETE;
import static java.nio.file.StandardWatchEventKinds.ENTRY_MODIFY;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.nio.file.FileSystems;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.WatchEvent;
import java.nio.file.WatchKey;
import java.nio.file.WatchService;

/**
 * Hello world!
 *
 */
public class App {
    public static void main(String[] args) {
        System.out.println("Hello World!");
        try {
			WatchService watcher = FileSystems.getDefault().newWatchService();
            Path testPath = Paths.get("D:\\Github\\Java\\007-Maven\\01-Console\\myconsoleapp\\src");
            // FILE_TREE is for nesting watching
            testPath.register(watcher, new WatchEvent.Kind[] {ENTRY_MODIFY, ENTRY_CREATE, ENTRY_DELETE}, FILE_TREE);
            
            while(true) {
                WatchKey k = watcher.take();
                Thread.sleep(1000);
                for (WatchEvent<?> e : k.pollEvents()) {
                    Object c = e.context();
                    System.out.printf("%s %d %s\n", e.kind(), e.count(), c);
                }
                k.reset();
                // this won't pop up a cmd window
                Process proc = Runtime.getRuntime().exec("D:\\Github\\Java\\008-Tools\\01-MavenWatch\\src\\main\\resources\\task1.bat");
                // Read the output from the command
                BufferedReader stdInput = new BufferedReader(new InputStreamReader(proc.getInputStream()));
                System.out.println("Here is the standard output of the command:\n");
                String s = null;
                while ((s = stdInput.readLine()) != null) {
                    System.out.println(s);
                }
                // // Another way to read output from the command
                // InputStream is = proc.getInputStream();
                // int i = 0;
                // while( (i = is.read() ) != -1) {
                //     System.out.print((char)i);
                // }

                // this will pop up a separate cmd window
                // Process proc = Runtime.getRuntime().exec("cmd /c start D:\\Github\\Java\\008-Tools\\01-MavenWatch\\src\\main\\resources\\task1.bat");
                proc.waitFor();
            }
		} catch (IOException e) {
			e.printStackTrace();
		} catch (InterruptedException e1) {
			e1.printStackTrace();
		}
    }
}
