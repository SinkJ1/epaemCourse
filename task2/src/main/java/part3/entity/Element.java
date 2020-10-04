package part3.entity;

import java.util.Arrays;
import java.util.Objects;

public class Element {

    private elementType type;

    private String value;

    private int length;

    private boolean isLast;

    public Element() {
    }

    public Element(elementType type, String value,int length) {
        this.type = type;
        this.value = value;
        this.length = length;
    }

    public Element(elementType type, String value, int length, boolean isLast) {
        this.type = type;
        this.value = value;
        this.length = length;
        this.isLast = isLast;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Element element = (Element) o;
        return length == element.length &&
                isLast == element.isLast &&
                type == element.type &&
                value.toString().equals(element.value.toString());
    }

    public elementType getType() {
        return type;
    }

    public void setType(elementType type) {
        this.type = type;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public int getLength() {
        return length;
    }

    public boolean isLast() {
        return isLast;
    }

    public void setLast(boolean last) {
        isLast = last;
    }

    public void setLength(int length) {
        this.length = length;
    }

    @Override
    public String toString() {
        return value.toString();
    }
}

