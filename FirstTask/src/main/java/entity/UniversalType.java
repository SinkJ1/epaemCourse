package entity;

public class UniversalType extends Auto {

    public UniversalType(int id, String name, double fuelConsumption, int maxSpeed, double cost) {
        super(id, name, fuelConsumption, maxSpeed, cost,BodyType.UNIVERSAL);
    }

}
