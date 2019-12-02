package newVersion2;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Semaphore;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.locks.ReentrantLock;

public class Program {

    private static List<Place> placeList = new ArrayList<>();

    static List<Car2> car = new ArrayList<>();

    public static void main(String[] args) {
        Place place = new Place(1);
        place.setEmpty(new AtomicBoolean(true));
        Place place2 = new Place(2);
        place2.setEmpty(new AtomicBoolean(true));
        placeList.add(place);
        placeList.add(place2);

        Program program = new Program();
        Semaphore semaphore = new Semaphore(2);
        ReentrantLock locker = new ReentrantLock();
        for(int i = 0; i < 5; i++){
            car.add(new Car2(program,true,500,semaphore,locker));
        }for(int i = 0; i < 1; i++){
            car.add(new Car2(program,false,0,semaphore,locker));
        }
    }


    public List<Place> getPlaceList() {
        return placeList;
    }
}
