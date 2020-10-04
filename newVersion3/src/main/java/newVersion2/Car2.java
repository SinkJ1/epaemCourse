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

    private static final Logger log = LogManager.getLogger(Car2.class);

    private boolean canSwap;

    Semaphore semaphore;

    public Car2(Program program, boolean wait,int time,Semaphore semaphore,ReentrantLock locker,boolean canSwap){
        this.program = program;
        this.wait = wait;
        this.time = time;
        this.semaphore = semaphore;
        this.locker = locker;
        this.canSwap = canSwap;
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
            if(place.getEmpty().get()){
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
            program.getCars().add(this);
            System.out.println(thread.getName() + " in place " + place.getId());
            thread.sleep(time);
            if(canSwap && locker.tryLock()){
                swap(this);
                locker.unlock();
            }
            place.setEmpty(new AtomicBoolean(true));
            program.getCars().remove(this);
            semaphore.release();
            System.out.println(thread.getName() + " away " + place.getId());
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
            int i = program.getCars().indexOf(this);
            if(i >= 0){
                swapEl(program.getCars().get(i+1));
            }else if(i <= program.getCars().size()){
                swapEl(program.getCars().get(i-1));
            }
        }catch (IndexOutOfBoundsException e){
            log.warn(e);
        }
    }

    private void swapEl(Car2 nextCar){
        System.out.println(thread.getName() + " and " + nextCar.thread.getName() + " swap place");
        Place place = this.place;
        this.place = nextCar.place;
        nextCar.place = place;
    }

}