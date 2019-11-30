import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Parking extends Thread {

    private int id;

    private boolean value = true;

    private Program prog;

    private Lock lock = new ReentrantLock();

    public Parking(Program prog, int id){
        this.prog = prog;
        this.id = id;
    }

    @Override
    public void run(){
        while(true){
            while(canParking()){
                System.out.println("kk");
                prog.getCarQueue().stream().forEach(car -> parkingOnQueue(car));
            }
        }
    }

    private boolean canParking(){
        return value;
    }

    public void setCanParking(){
        value = true;
    }

    private void parkingOnQueue(Car car){
        if(car != null && lock.tryLock()) {
            car.place = this;
            car.onParking = true;
            value = false;
            System.out.println("Car " + car.name + " in place " + id);
            lock.unlock();
            prog.getCarQueue().remove(car);
        }
    }

    public boolean parking(Car car){

        if(canParking() && lock.tryLock()){
            value = false;
            lock.unlock();
            System.out.println("Car " + car.name + " in place " + id);
            return true;
        }
        return false;
    }

}
