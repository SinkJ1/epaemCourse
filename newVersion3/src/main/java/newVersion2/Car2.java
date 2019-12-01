package newVersion2;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.concurrent.Semaphore;

public class Car2 {
    private Thread thread;

    private Program program;

    private boolean wait;

    private Place place;

    private int time;

    private static final Logger log = LogManager.getLogger(Car.class);

    Semaphore semaphore;

    public Car2(Program program, boolean wait,int time){
        this.program = program;
        this.wait = wait;
        this.time = time;
        thread = new Thread(this::run);
        semaphore = new Semaphore(program.getPlaceList().size());
        thread.start();
    }

    private void run(){
        if(semaphore.tryAcquire()){
            parking();
        }
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
        try{
            System.out.println(thread.getName() + " in place " + place.id);
            thread.sleep(500);
            place.empty = true;
            semaphore.release();
            System.out.println(thread.getName() + " away " + place.id);
        }catch (InterruptedException e){
            log.warn(e);
        }
    }

    private void falseParking(){
        System.out.println("car " + thread.getName() + " waiting");
        try{
            thread.sleep(time);
            if(!parking()){
                System.out.println("Car " + thread.getName() + " away");
            }
            semaphore.release();
        }catch (InterruptedException e){
            log.warn(e);
        }
    }


}
