package org.example;

import part3.entity.Element;
import part3.entity.Sentence;
import part3.entity.elementType;
import part3.fileWork.Parser;
import part3.fileWork.TextBuilder;
import part3.fileWork.TextFileWorker;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


/**
 * Hello world!
 *
 */
public class App 
{
    private static final String path = "textFiles/text.txt";
    private static final String path2 = "textFiles/text2.txt";

    public static void main( String[] args ){


        TextFileWorker thw = new TextFileWorker();
        TextBuilder tb = new TextBuilder();
        Parser parser = new Parser();
        List<Sentence> abc = tb.buildSentence(parser.elementsSplit(thw.readText(path)));
        List<Sentence> abc1 = tb.replaceWord(1,3,"sssss",abc);
        thw.writeText(tb.textBuild(abc1),path2);
    }
}