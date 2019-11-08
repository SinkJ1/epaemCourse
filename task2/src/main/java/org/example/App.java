package org.example;

import text.TextBuild;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Hello world!
 *
 */
public class App 
{
    String str = "";

    public static void main( String[] args ) throws IOException {
        String str = "Hello 123124 -8.8 GJj, sdkkds. sldkfj 1.";
        TextBuild te = new TextBuild();
        te.getText("E:\\rep\\epamCourse\\task2\\src\\main\\java\\resources\\TextFlle.xls");

        File file = new File("textFiles/text.txt");
        FileOutputStream fileOutputStream = new FileOutputStream(file);

        String greetings = "Привет! Добро пожаловать на JavaRush - лучшй сайт для тех, кто хочет стать программистом!";

        //fileOutputStream.write(greetings.getBytes());

        //fileOutputStream.close();

    }
}