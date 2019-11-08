package org.example;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class JustClass {
        Set<String> stringList = new HashSet();
        String replased = "";
        String a = "";

    public void addHooks(String string){

        Pattern pattern = Pattern.compile("([+-]?([0-9]*[.])?[0-9]+)");
        Matcher matcher = pattern.matcher(string);
        replased = string;
        while (matcher.find()){
            stringList.add(matcher.group());
            replased = replased.replace(matcher.group() ,"(" + matcher.group() + ")" );

        }

        //replased = replased.replace(matcher.group() ,"(" + 8 + ")" );
        for(String st :stringList){
           // replased = string.replaceAll("([+-]?([0-9]*[.])?[0-9]+)*(^[^(]*)" ,"(" + st + ")" );
         //   System.out.println(replased);
        }

        System.out.println(replased + "--");

    }

    public void find(){
        Pattern pattern = Pattern.compile("(^[^(]*)*[А-ЯA-Z\\@]((т.п.|т.д.|пр.|т.е.|т.о.)|[^?!.\\(]|\\([^\\)]*\\))*[.?!]");
        Matcher matcher = pattern.matcher(replased);
        while (matcher.find()){
            System.out.println(matcher.group());
        }
    }

    public void heap(){

      /* v1 String input = "Hello (8.8) Java (8.8)! Hello JavaScript! JavaSE (8).";
        Pattern pattern = Pattern.compile("([+-]?([0-9]*[.])?[0-9]+)*[А-ЯA-Z\\@]((т.п.|т.д.|пр.|т.е.|т.о.)|[^?!.\\(]|\\([^\\)]*\\))*[.?!]");
        Matcher matcher = pattern.matcher(input);
        while(matcher.find()) {
            //System.out.println(matcher.group());
        }

        JustClass justClass = new JustClass();
        justClass.addHooks(input);
        justClass.find();

        Double a = 8.0;
        System.out.println(String.valueOf(a));*/
    }

}
