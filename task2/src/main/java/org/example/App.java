package org.example;

import part2.TextFileWorker;
import part2.Parser;

/**
 * Hello world!
 *
 */
public class App 
{
    private static final String path = "textFiles/text.txt";
    private static final String path2 = "textFiles/text2.txt";

    public static void main( String[] args ){

        TextFileWorker tfw2 = new TextFileWorker();
        Parser parser = new Parser();
        parser.createSentence(parser.lineParser(tfw2.readText(path))).stream().forEach(System.out::println);


    }
}