package com.rohim.consoleapp;

import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

public class App {
    public static void main(String[] args) {
        String msg = "Text to save to file 22222" + System.lineSeparator();

        // ================================================
        // ============ First way for doing it ============
        // ================================================
        try {
            // will create a file, if not exist
            Files.write(
                    Paths.get("./fileName.txt"),
                    msg.getBytes(StandardCharsets.UTF_8),
                    StandardOpenOption.CREATE, StandardOpenOption.APPEND);

            Files.write(
                    Paths.get("./fileName.txt"),
                    msg.getBytes(StandardCharsets.UTF_8),
                    StandardOpenOption.CREATE, StandardOpenOption.APPEND);
        } catch (IOException e) {
            e.printStackTrace();
        }



        // ===============================================
        // =========== Second way for doing it ===========
        // ===============================================
        Writer writer = null;
        try {
            writer = new BufferedWriter(
                    new OutputStreamWriter(
                            new FileOutputStream("filename2.txt"),
                            StandardCharsets.UTF_8));

            writer.write(msg);
            writer.write(msg);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                writer.close();
            } catch (Exception ex) {
                /* ignore */
            }
        }
    }
}