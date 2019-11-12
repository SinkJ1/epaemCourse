package part2;

import entity.Element;
import entity.elementType;

import java.util.ArrayList;
import java.util.List;

public class TextBuilder {

    char [] chars;

    public List<Object> replaceWords(int id, int length, List<Object> sentenceList, String newString){

        Object obj = sentenceList.get(id);
        Element element = (Element) obj;

        for(int i = 0; i < element.getValue().length;i++){
            Object a = element.getValue()[i].toString();
            int b = a.toString().length();
            if(element.getValue().length == length){
                element.getValue()[i] = newString;
            }
        }
        sentenceList.set(id,element);
        return sentenceList;
    }

    public List<Object> buildText(List<Object> objectList){

        List<Object> textList = new ArrayList<>();
        StringBuilder textBuilder = new StringBuilder();

        for(Object object : objectList){
            Element e1 = new Element();
            e1.setType(elementType.sentence);
            e1 = (Element) object;
            for(int i = 0; i < e1.getValue().length;i++){
                textBuilder.append(e1.getValue()[i]);
            }
            textList.add(textBuilder);
            textBuilder.setLength(0);
        }
        return textList;
    }

    private String replace(int id, StringBuilder word,String newString, List<String> sentenceList){
        String newSentence = sentenceList.get(id);
        return newSentence.replace(word,newString);
    }
}
