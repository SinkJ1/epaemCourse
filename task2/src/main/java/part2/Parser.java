package part2;

import entity.Element;
import entity.elementType;

import java.util.ArrayList;
import java.util.List;

public class Parser {

    private List<String> sentenceList = new ArrayList<>();
    private StringBuilder stringBuilder = new StringBuilder();
    private char charArray[];

    public List<Object> lineParser(List<String> lineList){

        for(String line : lineList) {
            sentenceList.add(deleteBlanks(line.toCharArray()));
        }

        return splitByElements(sentenceList);
    }

    private String deleteBlanks(char[] charArray){

        StringBuilder line = new StringBuilder();

        for(int i = 0; i < charArray.length - 1; i++){
            if(charArray[i] != ' '){
                line.append(charArray[i]);
                if(i + 2 == charArray.length && charArray[i+1] != ' '){
                    line.append(charArray[i+1]);
                }
            }else{
                if(charArray[i+1] != ' '){
                    if(charArray[0] == ' '){
                    line.append(charArray[0] = charArray[i+1]);
                    i++;
                   }else{
                        line.append(charArray[i]);
                    }
                }
            }
        }
        return line.toString();
    }

    private List<Object> splitByElements(List<String> lineList){

        List<Object> objectList = new ArrayList();

        for(String line : lineList){
            charArray = line.toCharArray();
            for(int i = 0 ; i < charArray.length; i++){
                if(String.valueOf(charArray[i]).matches("[А-яA-z]")){
                    stringBuilder.append(charArray[i]);
                }else{
                    if(stringBuilder.length() > 0){
                        objectList.add(new Element(elementType.word,stringBuilder.toString()));
                        stringBuilder.setLength(0);
                    }
                        stringBuilder.append(charArray[i]);
                        objectList.add(new Element(elementType.punctuationMark,stringBuilder.toString()));
                        stringBuilder.setLength(0);
                }
            }

        }
        return objectList;
    }

        List<List<Object>> sentenceList1 = new ArrayList<>();
    public List<List<Object>> createSentence(List<Object> elementsList){
        List<Object> booferList = new ArrayList<>();

        for(Object object : elementsList){
            Element element = (Element) object;
            booferList.add(object);
            if(element.getType() == elementType.punctuationMark && (element.getValue() == "." || element.getValue() == "?" || element.getValue().equals("!"))){
                sentenceList1.add(booferList);
                booferList.clear();// error
            }
        }
        return sentenceList1;
    }

}
