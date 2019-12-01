package newVersion2;

import java.util.ArrayList;
import java.util.List;

public class Program {

    private static List<Place> placeList = new ArrayList<>();

    static List<Car> car = new ArrayList<>();

    public static void main(String[] args) {
        placeList.add(new Place(1));
        placeList.add(new Place(2));

        Program program = new Program();

        for(int i = 0; i < 5; i++){
            car.add(new Car(program,true,500));
        }for(int i = 0; i < 1; i++){
            car.add(new Car(program,false,0));
        }
    }


    public List<Place> getPlaceList() {
        return placeList;
    }
}
