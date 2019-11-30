import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class Program {


    private static BlockingQueue<Car> carQueue = new ArrayBlockingQueue<>(20,true);

    private static List<Parking> placeList = new ArrayList<>();

    public static void main(String[] args) {

      /*  Program prog = new Program();

        new Car("name",prog).start();
        new Car("name1",prog).start();
        new Car("name2",prog).start();
        new Car("name3",prog).start();
        new Car("name4",prog).start();
        new Car("name5",prog).start();
        new Car("name6",prog).start();
        new Car("name7",prog).start();
        new Car("name8",prog).start();
        new Car("name9",prog).start();


        placeList.add(new Parking(prog,1));
        placeList.add(new Parking(prog,2));

        placeList.forEach(Thread::start);*/

    }

    public BlockingQueue<Car> getCarQueue() {
        return carQueue;
    }

    public List<Parking> getPlaceList() {
        return placeList;
    }
}
