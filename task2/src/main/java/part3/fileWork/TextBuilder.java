package part3.fileWork;

import part3.entity.Sentence;
import part3.entity.Element;
import part3.entity.elementType;

import java.util.ArrayList;
import java.util.List;

public class TextBuilder {

    private List<String> newLineList = new ArrayList<>();

    public List<Sentence> buildSentence(List<Element> elementList){

        List<Sentence> sentenceList = new ArrayList<>();

        List<Element> newElementList = new ArrayList<>();

        for(Element element: elementList){

            if(element.getType() != elementType.punctuationMark){
                newElementList.add(element);
            }else{
                newElementList.add(element);
                Sentence sentence = new Sentence();
                sentence.setElementList(new ArrayList<>(newElementList));
                sentenceList.add(sentence);
                newElementList.clear();
            }
        }

        return  sentenceList;
    }

    public List<Sentence> replaceWord(int id, int length, String newWord, List<Sentence> sentenceList){

        for(Element element: sentenceList.get(id).getElementList()){

            if(element.getLength() == length && element.getType() == elementType.word){
                element.setValue(newWord);
            }
        }

        return sentenceList;
    }


    public List<String> textBuild(List<Sentence> sentenceList){

        StringBuilder stringBuilder = new StringBuilder();
        List<String> line = new ArrayList<>();
        for(Sentence sentence :sentenceList){
            for(Element element : sentence.getElementList()){
                if(element.getType() == elementType.blank){
                    for(int i = 0; i < element.getLength();i++){
                        stringBuilder.append(element.getValue());
                    }
                }else{
                    stringBuilder.append(element.getValue());
                }
                if(element.isLast()){
                    line.add(stringBuilder.toString());
                    stringBuilder.setLength(0);

                }
            }
        }
        return line;
    }


    private int getWordCount(String text){
        String[] word=text.split("\\s+");
        return  word.length;
    }


}
