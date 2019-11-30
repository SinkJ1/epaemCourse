package newVersion;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Objects;

public class Place{

    private int id;

    private boolean open = true;

    private Car car;

    public Place(int id){
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public boolean isOpen() {
        return open;
    }

    public void setOpen(boolean open) {
        this.open = open;
    }

    public Car getCar() {
        return car;
    }

    public void setCar(Car car) {
        this.car = car;
    }

    private static final Logger log = LogManager.getLogger(Place.class);

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Place place = (Place) o;
        return id == place.id &&
                open == place.open &&
                Objects.equals(car, place.car);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, open, car);
    }

    public void parking(Car car){
        this.setOpen(false);
        this.car = car;
        log.info(car.name + " in place " + id);
    }

}
