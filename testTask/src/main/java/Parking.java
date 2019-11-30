import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Parking extends Thread {

    public int id;

    private boolean value = true;

    private Program prog;

    int i =0;

    private Lock lock = new ReentrantLock();

    public Parking(Program prog, int id){
        this.prog = prog;
        this.id = id;
    }

    @Override
    public void run(){
        while(true){
            while(canParking()) {
                while (canParking()) {
                    System.out.println("s");
                    Car car = prog.getCarQueue().poll();
                    parkingOnQueue(car);
                }
            }
        }
    }

    public boolean canParking(){
        return value;
    }

    public void setCanParking(boolean value){
        this.value = value;
    }

    private void parkingOnQueue(Car car){
        if(car != null && lock.tryLock()) {
            car.place = this;
            car.onParking = true;
            setCanParking(false);
            System.out.println("Car " + car.name + " in place " + id);
            lock.unlock();
            prog.getCarQueue().remove(car);
        }
    }

    public boolean parking(Car car){

        if(canParking() && lock.tryLock()){
            setCanParking(false);
            lock.unlock();
            System.out.println("Car " + car.name + " in place " + id);
            return true;
        }
        return false;
    }

}
