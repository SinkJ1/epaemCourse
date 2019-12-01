package newVersion2;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.concurrent.Semaphore;

public class Car {

    private Thread thread;

    private Program program;

    private boolean wait;

    private Place place;

    private int time;

    private static final Logger log = LogManager.getLogger(Car.class);

    Semaphore semaphore = new Semaphore(program.getPlaceList().size());

    public Car(Program program, boolean wait,int time){
        this.program = program;
        this.wait = wait;
        this.time = time;
        thread = new Thread(this::run);
        thread.start();
    }

    private void run(){
        parking();
    }

    private boolean parking(){
        for(Place place : program.getPlaceList()){
            if(place.empty){
                place.empty = false;
                this.place = place;
                tryParking();
                return true;
            }
        }
        if(wait && place == null){
            falseParking();
        }
        return false;
    }

    private void tryParking(){
        System.out.println("car "+ thread.getName() + "on place" + place.id);
        try{
            thread.sleep(100);
            swap(this);
            System.out.println("Car " + thread.getName() + " away" + place.id);
            clear();
        }catch (InterruptedException e){
            log.warn(e);
        }
    }

    private void clear(){
        place.empty = true;
        place = null;
    }

    private void falseParking(){
        System.out.println("car " + thread.getName() + " waiting");
        try{
            thread.sleep(time);
            if(!parking()){
                System.out.println("Car " + thread.getName() + " away");
            }
        }catch (InterruptedException e){
            log.warn(e);
        }
    }

    private void swap(Car car){
        //develop
    }


}
