package newVersion;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Objects;
import java.util.Random;

public class Car extends Thread {

    String name;

    private Place place;

    private Parking parking;

    private Program program;

    private boolean onPlace;

    private static final Logger log = LogManager.getLogger(Car.class);

    public Car(String name){
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Car car = (Car) o;
        return onPlace == car.onPlace &&
                Objects.equals(name, car.name) &&
                Objects.equals(place, car.place) &&
                Objects.equals(parking, car.parking) &&
                Objects.equals(program, car.program);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, place, parking, program, onPlace);
    }

    public Car(String name, Parking parking, Program program){
        this.name = name;
        this.parking = parking;
        this.program = program;

    }


    @Override
    public void run() {
        try{
            parking();
            if(this.onPlace){
                sleep(getWaitTime());
                if(getSwapValue()){
                    swap(this);
                    sleep(getWaitTime());
                }
                place.setOpen(true);
                onPlace = false;
                log.info("car " + name + " is way out" + "from " + place.getId());
            }else{
                sleep(getWaitTime());
                if(!this.onPlace){
                    if(!parking()){
                        program.getCarQueue().remove(this);
                        log.info("car " + this.name + " is way out from queue");
                    }
                }
            }

        }catch (InterruptedException ex){
            log.warn(ex);
        }
    }

    private boolean parking(){
        for(Place place : parking.getPlaceList()){
            if(place.isOpen()){
                place.parking(this);
                this.place = place;
                this.onPlace = true;
                return true;
            }
        }
        if(!onPlace && !program.getCarQueue().contains(this)){
            program.getCarQueue().add(this);
            log.info("car" + name + " in queue");
        }
        return false;
    }

    private int getWaitTime(){
        return 100 + (int) (Math.random() * 200);
    }

    private boolean getSwapValue(){
        return new Random().nextBoolean();
    }

    private void swap(Car car){
        try {
            int i = parking.getPlaceList().indexOf(car.place);
            if(i >= 0){
                swapEl(parking.getPlaceList().get(i+1),car);
            }else if(i <= parking.getPlaceList().size()){
                swapEl(parking.getPlaceList().get(i-1),car);
            }
        }catch (IndexOutOfBoundsException e){

        }
    }

    private void swapEl(Place place, Car car){
        log.info(car.name + " swapped place from " + place.getCar().name);
        Car newCar = place.getCar();
        newCar.place = car.place;
        newCar.place.setCar(newCar);
        car.place = place;
        place.setCar(car);
    }

}
