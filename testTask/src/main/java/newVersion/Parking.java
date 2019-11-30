package newVersion;

import java.util.ArrayList;
import java.util.List;

public class Parking {

    private List<Place> placeList = new ArrayList<>();

    public List<Place> getPlaceList() {
        return placeList;
    }

    public void addElement(Place place){
        placeList.add(place);
    }


}
