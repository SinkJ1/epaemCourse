package part3.fileWork;

import part3.entity.Element;
import part3.entity.elementType;

import java.util.ArrayList;
import java.util.List;

public class Parser {

    public List<Element> elementsSplit(List<String> lineList){

        List<Element> elementList = new ArrayList<>();

        for(String line : lineList){
            char [] charArray = line.toCharArray();
            boolean isLast = false;
            for(int i = 0; i < charArray.length;i++){
                if(String.valueOf(charArray[i]).matches("[A-zА-я]")) {
                   Element element = splitWord(i,charArray);
                   if(i + 1 == charArray.length){
                       isLast = true;
                   }
                   element.setLast(isLast);
                   i +=element.getLength() - 1;
                   elementList.add(element);
                }else if(String.valueOf(charArray[i]).matches("[.!?]")){
                    Element element = splitPunctuation(i,charArray);
                    if(i + 1 == charArray.length){
                        isLast = true;
                    }
                    element.setLast(isLast);
                    i += element.getLength() - 1;
                    elementList.add(element);
                }else if(String.valueOf(charArray[i]).matches("[ ]")){
                    Element element = splitBlank(i,charArray);
                    if(i + 1 == charArray.length){
                        isLast = true;
                    }
                    element.setLast(isLast);
                    i += element.getLength() - 1;
                    elementList.add(element);
                }else if(String.valueOf(charArray[i]).matches("[0-9]")){
                    Element element = splitNumber(i,charArray);
                    if(i + 1 == charArray.length){
                        isLast = true;
                    }
                    element.setLast(isLast);
                    i += element.getLength() - 1;
                    elementList.add(element);
                }else{
                    if(i + 1 == charArray.length){
                        isLast = true;
                    }
                    elementList.add(new Element(elementType.other,String.valueOf(charArray[i]),1,isLast));
                }
            }
        }

    return elementList;
    }

    private Element splitWord(int id, char[] array){

        StringBuilder stringBuilder = new StringBuilder();
        int length = 0;

        while(id < array.length && String.valueOf(array[id]).matches("[A-zА-я]")){
            stringBuilder.append(array[id]);
            length++;
            id++;
        }

        return new Element(elementType.word,stringBuilder.toString(),length);
    }

    private Element splitBlank(int id, char[] array){

        StringBuilder stringBuilder = new StringBuilder();

        int length= 0;

        stringBuilder.append(" ");
        while(id < array.length && array[id] == ' '){
            id++;
            length++;
        }

        return new Element(elementType.blank,stringBuilder.toString(),length);
    }

    private Element splitPunctuation(int id, char[] array){

        StringBuilder stringBuilder = new StringBuilder();

        int length = 0;

        while(id < array.length && String.valueOf(array[id]).matches("[.!?]")){
            stringBuilder.append(array[id]);
            id++;
            length++;

        }
        return new Element(elementType.punctuationMark,stringBuilder.toString(),length);
    }

    private Element splitNumber(int id, char[] array){

        StringBuilder stringBuilder = new StringBuilder();
        int length = 0;
        while(id < array.length && (String.valueOf(array[id]).matches("[0-9]") || (String.valueOf(array[id]).matches("[.]") && id + 1 != array.length && String.valueOf(array[id+1]).matches("[0-9]")))){
            stringBuilder.append(array[id]);
            id++;
            length++;
        }
        return new Element(elementType.number,stringBuilder.toString(),length);
    }

}
