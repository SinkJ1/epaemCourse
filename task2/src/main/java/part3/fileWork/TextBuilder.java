package part3.fileWork;

import part3.entity.Element;
import part3.entity.elementType;

import java.util.ArrayList;
import java.util.List;

public class TextBuilder {

    public List<Element> buildSentence(List<Element> elementList){
        List<Element> sentenceList = new ArrayList<>();

        for(Element element: elementList){
            Element sentence = new Element();
            sentence.setType(elementType.sentence);
            while (element.getType() != elementType.punctuationMark){

            }
        }

        return  sentenceList;
    }

}
