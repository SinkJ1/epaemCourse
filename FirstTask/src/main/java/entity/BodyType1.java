package entity;

public class BodyType1 extends Auto{

    public BodyType1(int id, String name, double fuelConsumption, int maxSpeed, double cost) {
        super(id, name, fuelConsumption, maxSpeed, cost,BodyType.FIRST);
    }

}
