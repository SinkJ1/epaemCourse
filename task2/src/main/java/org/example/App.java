package org.example;

import text.TextBuild;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Hello world!
 *
 */
public class App 
{
    private static final String path = "textFiles/text.txt";

    public static void main( String[] args ) throws IOException {
        TextBuild te = new TextBuild();
        te.getText(path);
       // te.lineParser().stream().forEach(System.out::println);
        //System.out.println(te.lineParser().get(2));

        //te.getSentenceList().stream().forEach(System.out::println);
    }
}