package entity;

public class CoupeType extends Auto{

    public CoupeType(int id, String name, double fuelConsumption, int maxSpeed, double cost) {
        super(id, name, fuelConsumption, maxSpeed, cost,BodyType.Coupe);
    }

}
