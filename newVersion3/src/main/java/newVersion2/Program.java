package newVersion2;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Semaphore;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.locks.ReentrantLock;

public class Program {

    private static List<Place> placeList = new ArrayList<>();

    static List<Car2> car = new ArrayList<>();

    private static List<Car2> cars = new ArrayList<>();

    public static void main(String[] args) {
        Place place = new Place(1);
        place.setEmpty(new AtomicBoolean(true));
        Place place2 = new Place(2);
        place2.setEmpty(new AtomicBoolean(true));
        Place place3 = new Place(3);
        place3.setEmpty(new AtomicBoolean(true));
        placeList.add(place);
        placeList.add(place2);
        placeList.add(place3);

        Program program = new Program();
        Semaphore semaphore = new Semaphore(placeList.size());
        ReentrantLock locker = new ReentrantLock();
        for(int i = 0; i < 5; i++){
            car.add(new Car2(program,true,500,semaphore,locker,false));
        }
            car.add(new Car2(program,true,500,semaphore,locker,true));
            car.add(new Car2(program,true,500,semaphore,locker,false));
        for(int i = 0; i < 1; i++){
            car.add(new Car2(program,false,0,semaphore,locker,false));
        }
    }

    public List<Car2> getCars(){
        return cars;
    }


    public List<Place> getPlaceList() {
        return placeList;
    }
}
