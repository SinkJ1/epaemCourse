package newVersionTest;

import newVersion.Car;
import newVersion.Place;
import org.testng.Assert;
import org.testng.annotations.Test;

public class PlaceTest {

    @Test
    public void parkingTest(){

        Place place = new Place(1);
        place.parking(new Car("Name"));

        Place place1 = new Place(1);
        place1.setOpen(false);
        place1.setCar(new Car("Name"));

        Assert.assertEquals(place,place1);
    }


}
