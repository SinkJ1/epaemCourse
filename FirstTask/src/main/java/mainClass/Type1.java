package mainClass;

public class Type1 extends Auto{

    private BodyType bodyType;

    public Type1(int id, String name, double fuelConsumption, int maxSpeed, double cost) {
        super(id, name, fuelConsumption, maxSpeed, cost);
        this.bodyType = BodyType.FIRST;
    }

    public BodyType getBodyType() {
        return bodyType;
    }

    @Override
    public String toString() {
        return "Type1{" +
                "bodyType=" + bodyType +
                "} " + super.toString();
    }
}
