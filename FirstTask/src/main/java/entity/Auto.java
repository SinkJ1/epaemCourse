package entity;

public class Auto {

    private int id;

    private String name;

    private double fuelConsumption;

    private int maxSpeed;

    private double cost;

    private BodyType bodyType;

    public Auto(int id, String name, double fuelConsumption, int maxSpeed, double cost,BodyType bodyType) {
        this.id = id;
        this.name = name;
        this.fuelConsumption = fuelConsumption;
        this.maxSpeed = maxSpeed;
        this.cost = cost;
        this.bodyType = bodyType;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getFuelConsumption() {
        return fuelConsumption;
    }

    public void setFuelConsumption(double fuelConsumption) {
        this.fuelConsumption = fuelConsumption;
    }

    public int getMaxSpeed() {
        return maxSpeed;
    }

    public void setMaxSpeed(int maxSpeed) {
        this.maxSpeed = maxSpeed;
    }

    public double getCost() {
        return cost;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }

    public BodyType getBodyType() {
        return bodyType;
    }

    public void setBodyType(BodyType bodyType) {
        this.bodyType = bodyType;
    }

    @Override
    public String toString() {
        return "Auto{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", fuelConsumption=" + fuelConsumption +
                ", maxSpeed=" + maxSpeed +
                ", cost=" + cost +
                ", bodyType=" + bodyType +
                '}';
    }
}
