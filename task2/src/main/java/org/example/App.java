package org.example;

import text.Parser;
import text.TextBuilder;
import text.TextFileWorker;

import java.util.ArrayList;
import java.util.List;

/**
 * Hello world!
 *
 */
public class App 
{
    private static final String path = "textFiles/text.txt";
    private static final String path2 = "textFiles/text2.txt";

    public static void main( String[] args ){
        TextFileWorker tfw = new TextFileWorker();
        tfw.readText(path);
        TextBuilder tb = new TextBuilder();
       // tb.replaceWords(4,3,Parser.getInstance().getSentenceList(),"new Words");
        List<String> abc = new ArrayList<>();
        abc.add("qwert!");
        abc.add("qwert!");
        abc.add("qwert!");
        abc.add("qwert!");
        abc.add("qwert!");
        abc.add("qwert!");
        abc.add("qwert!");
        abc.add("qwert!");
        abc.add("qwert!");
        tfw.writeText(abc,path2);
    }
}