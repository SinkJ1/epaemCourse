package entity;

public class Element {

    private elementType type;

    private String value;

    public Element() {
    }

    public Element(elementType type, String value) {
        this.type = type;
        this.value = value;
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

    @Override
    public String toString() {
        return value;
    }
}
