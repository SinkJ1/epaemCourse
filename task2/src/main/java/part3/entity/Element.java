package part3.entity;

import java.util.Arrays;

public class Element {

    private elementType type;

    private Object value;

    private int length;

    private boolean isLast;

    public Element() {
    }

    public Element(elementType type, Object value,int length) {
        this.type = type;
        this.value = value;
        this.length = length;
    }

    public Element(elementType type, Object value, int length, boolean isLast) {
        this.type = type;
        this.value = value;
        this.length = length;
        this.isLast = isLast;
    }

    public elementType getType() {
        return type;
    }

    public void setType(elementType type) {
        this.type = type;
    }

    public Object getValue() {
        return value;
    }

    public void setValue(Object value) {
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

