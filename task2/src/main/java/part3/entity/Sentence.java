package part3.entity;

import java.util.ArrayList;
import java.util.List;

public class Sentence {

    private elementType type;

    private List<Element> elementList = new ArrayList<>();

    public Sentence() {
        this.type = elementType.sentence;
    }

    public elementType getType() {
        return type;
    }

    public void setType(elementType type) {
        this.type = type;
    }

    public List<Element> getElementList() {
        return elementList;
    }

    public void setElementList(List<Element> elementList) {
        this.elementList = elementList;
    }

    public void addInElementList(Element element){
        elementList.add(element);
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();

        for(Element element : elementList){
            stringBuilder.append(element.getValue());
            stringBuilder.append(" ");
        }

        return stringBuilder.toString();
    }
}
