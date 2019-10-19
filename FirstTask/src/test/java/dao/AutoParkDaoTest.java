package dao;

import auto.Nissan;
import mainClass.Auto;
import mainClass.BodyType2;
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

        List<Auto> testListAuto = new ArrayList();
        testListAuto.add(nissan);
        testListAuto.add(nissan2);
        testListAuto.add(nissan3);
        Assert.assertEquals(AutoParkDao.getInstance().countSumCostAuto(testListAuto),369.0,0);
    }

    @Test
    public void findAutoBySpeedRangeTest(){
        BodyType2 nissan = new Nissan(1,"nissan",123.2,1235,123);
        BodyType2 nissan2 = new Nissan(1,"nissan1",126.2,1233,123);
        BodyType2 nissan3 = new Nissan(1,"nissan2",123.2,1235,123);

        List<Auto> testListAuto = new ArrayList();
        testListAuto.add(nissan);
        testListAuto.add(nissan2);
        testListAuto.add(nissan3);
        List<Auto> checkTestListAuto = new ArrayList();
        checkTestListAuto.add(nissan2);
        Assert.assertEquals(AutoParkDao.getInstance().findAutoBySpeedRange(testListAuto,1234,1222),checkTestListAuto);
    }

    @Test
    public void sortByFuelConsumptionTest(){
        BodyType2 nissan = new Nissan(1,"nissan",123.2,1235,123);
        BodyType2 nissan2 = new Nissan(1,"nissan1",126.2,1233,123);
        BodyType2 nissan3 = new Nissan(1,"nissan2",122.2,1235,123);

        List<Auto> testListAuto = new ArrayList();
        testListAuto.add(nissan);
        testListAuto.add(nissan2);
        testListAuto.add(nissan3);
        List<Auto> checkTestListAuto = new ArrayList();
        checkTestListAuto.add(nissan3);
        checkTestListAuto.add(nissan);
        checkTestListAuto.add(nissan2);
        Assert.assertEquals(AutoParkDao.getInstance().sortByFuelConsumption(testListAuto),checkTestListAuto);
    }

    @Test
    public void addAutoInListTest(){
        BodyType2 nissan3 = new Nissan(1,"nissan2",122.2,1235,123);

        AutoParkDao.getInstance().addInAutopark(nissan3);
        Assert.assertEquals(AutoParkDao.getInstance().getAutos().isEmpty(),false);
    }
}
