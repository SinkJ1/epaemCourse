package dao;

import auto.Nissan;
import entity.Auto;
import entity.BodyType2;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

public class AutoParkDaoTest {

    @Test
    public void countSumAutoInAutoParkTest(){
        BodyType2 nissan = new Nissan(1,"nissan",123.2,1234,123);
        BodyType2 nissan2 = new Nissan(1,"nissan1",126.2,1233,123);
        BodyType2 nissan3 = new Nissan(1,"nissan2",123.2,1234,123);

        AutoParkDao.getInstance().addInAutopark(nissan);
        AutoParkDao.getInstance().addInAutopark(nissan2);
        AutoParkDao.getInstance().addInAutopark(nissan3);
        Assert.assertEquals(AutoParkDao.getInstance().countSumCostAuto(AutoParkDao.getInstance().getAutos()),369.0,0);
        AutoParkDao.getInstance().getAutos().clear();
    }

    @Test
    public void findAutoBySpeedRangeTest(){
        BodyType2 nissan = new Nissan(1,"nissan",123.2,1235,123);
        BodyType2 nissan2 = new Nissan(1,"nissan1",126.2,1233,123);
        BodyType2 nissan3 = new Nissan(1,"nissan2",123.2,1235,123);

        AutoParkDao.getInstance().addInAutopark(nissan);
        AutoParkDao.getInstance().addInAutopark(nissan2);
        AutoParkDao.getInstance().addInAutopark(nissan3);
        List<Auto> checkTestListAuto = new ArrayList();
        checkTestListAuto.add(nissan2);
        Assert.assertEquals(AutoParkDao.getInstance().findAutoBySpeedRange(AutoParkDao.getInstance().getAutos(),1234,1222),checkTestListAuto);
        AutoParkDao.getInstance().getAutos().clear();
    }

    @Test(expectedExceptions = AutoParkDao.class)
    public void sortByFuelConsumptionTest(){
        BodyType2 nissan = new Nissan(1,"nissan",123.2,1235,123);
        BodyType2 nissan2 = new Nissan(1,"nissan1",126.2,1233,123);
        BodyType2 nissan3 = new Nissan(1,"nissan2",122.2,1235,123);

            AutoParkDao.getInstance().addInAutopark(nissan);
            AutoParkDao.getInstance().addInAutopark(nissan2);
            AutoParkDao.getInstance().addInAutopark(nissan3);

            List<Auto> checkTestListAuto = new ArrayList();

            checkTestListAuto.add(nissan3);
            checkTestListAuto.add(nissan);
            checkTestListAuto.add(nissan2);

            Assert.assertEquals(AutoParkDao.getInstance().sortByFuelConsumption(AutoParkDao.getInstance().getAutos()), checkTestListAuto);
        Exception e = caughtException();
        // Use JUnit, TestNG, AssertJ etc. assertions on the "e" exception
        assert e instanceof IndexOutOfBoundsException;
            AutoParkDao.getInstance().getAutos().clear();

    }

    @Test
    public void addAutoInListTest(){
        BodyType2 nissan3 = new Nissan(1,"nissan2",122.2,1235,123);

        AutoParkDao.getInstance().addInAutopark(nissan3);
        Assert.assertFalse(AutoParkDao.getInstance().getAutos().isEmpty());
        AutoParkDao.getInstance().getAutos().clear();
    }

    @Test
    public void throwIfOrderIsNull()  {
        AutoParkDao.getInstance().sortByFuelConsumption(null);
    }

}
