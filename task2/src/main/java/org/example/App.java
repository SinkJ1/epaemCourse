package org.example;

import part3.entity.Element;
import part3.entity.elementType;
import part3.fileWork.Parser;
import part3.fileWork.TextFileWorker;

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
        Parser parser = new Parser();

        String line = "Seeeee 8.822222 .JJJJJ! jjjjw?";

        Pattern pattern = Pattern.compile("[+-]?([0-9]*[.])?[0-9]+");
        Matcher matcher = pattern.matcher(line);
        Element element = new Element();
        element.setType(elementType.number);

        parser.elementsSplit(thw.readText(path)).stream().forEach(System.out::println);
    }
}