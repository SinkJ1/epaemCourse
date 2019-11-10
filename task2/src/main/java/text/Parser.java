package text;

import java.util.ArrayList;
import java.util.List;

public class Parser {

    private static Parser instance;
    private List<String> sentenceList = new ArrayList<>();
    private StringBuilder stringBuilder = new StringBuilder();
    private char charArray[];

    private Parser(){

    }

    public static Parser getInstance(){
        if(instance == null){
            instance = new Parser();
        }
        return instance;
    }

    public void lineParser(String line){

        charArray = line.toCharArray();

        for(int i = 0; i < charArray.length - 1;i++){
            stringBuilder.append(charArray[i]);
            if((charArray[i] == '.' || charArray[i] == '!' || charArray[i] == '?') && (charArray[i+1] == ' ' || String.valueOf(charArray[i+1]).matches("[А-Я]")) || i+2 == charArray.length){
                if(!String.valueOf(charArray[i+1]).matches("[а-я]") && i+2 == charArray.length){
                    stringBuilder.append(charArray[i+1]);
                }
                if(charArray[i+1] == ' '){
                    i++;
                }
                if(!(i+2 == charArray.length && String.valueOf(charArray[i+1]).matches("[а-я]"))){
                    sentenceList.add(stringBuilder.toString());
                    stringBuilder.setLength(0);
                }else{
                    stringBuilder.append(charArray[i+1] + " ");
                }
            }
        }
    }


    public List<String> getSentenceList(){
        return sentenceList;
    }

}
