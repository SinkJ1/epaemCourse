package part3.entity;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

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
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Sentence sentence = (Sentence) o;
        return type == sentence.type &&
                Objects.equals(elementList, sentence.elementList);
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
