package newVersion2;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Semaphore;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.locks.ReentrantLock;

public class Car2 {
    private Thread thread;

    private Program program;

    private boolean wait;

    private Place place;

    private int time;

    ReentrantLock locker;

    private static final Logger log = LogManager.getLogger(Car.class);

    private List<Car2> cars = new ArrayList<>();

    Semaphore semaphore;

    public Car2(Program program, boolean wait,int time,Semaphore semaphore,ReentrantLock locker){
        this.program = program;
        this.wait = wait;
        this.time = time;
        this.semaphore = semaphore;
        this.locker = locker;
        thread = new Thread(this::run);
        thread.start();
    }

    private void run(){
        if(semaphore.tryAcquire()){
            parking();
            semaphore.release();
        }else if(wait){
            falseParking();
        }
    }


    private boolean parking(){
        for(Place place : program.getPlaceList()){
            if(place.empty.get()){
                if(locker.tryLock()){
                    place.setEmpty(new AtomicBoolean(false));
                this.place = place;
                locker.unlock();
                tryParking();
                }
                return true;
            }
        }
        return false;
    }

    private void tryParking(){
        try{
            cars.add(this);
            System.out.println(thread.getName() + " in place " + place.id);
            thread.sleep(time);
            swap(this);
            place.setEmpty(new AtomicBoolean(true));
            cars.remove(this);
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
            if(semaphore.tryAcquire()){
                parking();
            }else {
                System.out.println(thread.getName() + " away ");
            }
        }catch (InterruptedException e){
            log.warn(e);
        }
    }

    private void swap(Car2 car){
        try {
            int i = cars.indexOf(this);
            if(i >= 0){
                swapEl(cars.get(i+1),this);
            }else if(i <= cars.size()){
                swapEl(cars.get(i-1),this);
            }
        }catch (IndexOutOfBoundsException e){
            log.warn(e);
        }
    }

    private void swapEl(Car2 nextCar , Car2 oldCar){

        Car2 car2 = nextCar;
        car2.place = nextCar.place;

        nextCar.place = oldCar.place;
        oldCar.place = car2.place;

    }

}
