package mainClass;

public class Type2 extends Auto {

    private BodyType bodyType;

    public Type2(int id, String name, double fuelConsumption, int maxSpeed, double cost) {
        super(id, name, fuelConsumption, maxSpeed, cost);
        this.bodyType = BodyType.TWO;
    }

    public BodyType getBodyType() {
        return bodyType;
    }

    @Override
    public String toString() {
        return "Type2{" +
                "bodyType=" + bodyType +
                "} " + super.toString();
    }
}
