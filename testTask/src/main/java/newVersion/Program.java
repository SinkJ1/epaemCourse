package newVersion;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class Program {

    private static BlockingQueue<Car> carQueue = new ArrayBlockingQueue<>(20,true);

    public static void main(String[] args) {

        Parking parking = new Parking();
        Program program = new Program();

        for(int i = 0; i < 2; i++){
            parking.addElement(new Place(i));
        }

        new Car("name",parking,program).start();
        new Car("name2",parking,program).start();
        new Car("name3",parking,program).start();
        new Car("name4",parking,program).start();
        new Car("name5",parking,program).start();
        new Car("name6",parking,program).start();
        new Car("name7",parking,program).start();

    }

    public static BlockingQueue<Car> getCarQueue() {
        return carQueue;
    }
}
