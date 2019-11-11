package entity;

import java.util.Arrays;

public class Element {

    private elementType type;

    private Object[] value;

    public Element() {
    }

    public Element(elementType type, Object[] value) {
        this.type = type;
        this.value = value;
    }

    public elementType getType() {
        return type;
    }

    public void setType(elementType type) {
        this.type = type;
    }

    public Object[] getValue() {
        return value;
    }

    public void setValue(Object[] value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return Arrays.toString(value);
    }
}
