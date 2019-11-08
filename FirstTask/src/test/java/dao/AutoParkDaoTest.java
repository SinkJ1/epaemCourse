package dao;

import auto.Nissan;
import entity.Auto;
import entity.UniversalType;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

public class AutoParkDaoTest {

    @Test
    public void countSumAutoInAutoParkTest(){
        UniversalType nissan = new Nissan(1,"nissan",123.2,1234,123);
        UniversalType nissan2 = new Nissan(1,"nissan1",126.2,1233,123);
        UniversalType nissan3 = new Nissan(1,"nissan2",123.2,1234,123);

        AutoParkDao.getInstance().addInAutopark(nissan);
        AutoParkDao.getInstance().addInAutopark(nissan2);
        AutoParkDao.getInstance().addInAutopark(nissan3);

        Assert.assertEquals(AutoParkDao.getInstance().countSumCostAuto(AutoParkDao.getInstance().getAutos()),369.0,0);
        AutoParkDao.getInstance().getAutos().clear();
    }

    @Test
    public void findAutoBySpeedRangeTest(){
        UniversalType nissan = new Nissan(1,"nissan",123.2,1235,123);
        UniversalType nissan2 = new Nissan(1,"nissan1",126.2,1233,123);
        UniversalType nissan3 = new Nissan(1,"nissan2",123.2,1235,123);

        AutoParkDao.getInstance().addInAutopark(nissan);
        AutoParkDao.getInstance().addInAutopark(nissan2);
        AutoParkDao.getInstance().addInAutopark(nissan3);

        List<Auto> checkTestListAuto = new ArrayList();

        checkTestListAuto.add(nissan2);

        Assert.assertEquals(AutoParkDao.getInstance().findAutoBySpeedRange(AutoParkDao.getInstance().getAutos(),1234,1222),checkTestListAuto);
        AutoParkDao.getInstance().getAutos().clear();
    }

    @Test
    public void sortByFuelConsumptionTest(){
        UniversalType nissan = new Nissan(1,"nissan",123.2,1235,123);
        UniversalType nissan2 = new Nissan(1,"nissan1",126.2,1233,123);
        UniversalType nissan3 = new Nissan(1,"nissan2",122.2,1235,123);

            AutoParkDao.getInstance().addInAutopark(nissan);
            AutoParkDao.getInstance().addInAutopark(nissan2);
            AutoParkDao.getInstance().addInAutopark(nissan3);

            List<Auto> checkTestListAuto = new ArrayList();

            checkTestListAuto.add(nissan3);
            checkTestListAuto.add(nissan);
            checkTestListAuto.add(nissan2);

            Assert.assertEquals(AutoParkDao.getInstance().sortByFuelConsumption(AutoParkDao.getInstance().getAutos()), checkTestListAuto);

            AutoParkDao.getInstance().getAutos().clear();

    }

    @Test
    public void addAutoInListTest(){
        UniversalType nissan3 = new Nissan(1,"nissan2",122.2,1235,123);

        AutoParkDao.getInstance().addInAutopark(nissan3);
        Assert.assertFalse(AutoParkDao.getInstance().getAutos().isEmpty());
        AutoParkDao.getInstance().getAutos().clear();
    }

    @Test
    public void sortByFuelConsumptionTest_NullPointer()  {
        Assert.assertTrue(AutoParkDao.getInstance().sortByFuelConsumption(AutoParkDao.getInstance().getAutos()).isEmpty());
        AutoParkDao.getInstance().getAutos().clear();
    }

    @Test
    public void sortByFuelConsumptionTest_ListNullPointer(){
        List<Auto> autos = new ArrayList<>();
        autos.add(null);
        AutoParkDao.getInstance().sortByFuelConsumption(AutoParkDao.getInstance().getAutos());
        AutoParkDao.getInstance().getAutos().clear();
    }

    @Test
    public void countSumAutoInAutoParkTest_NullPointer(){
        Assert.assertEquals(AutoParkDao.getInstance().countSumCostAuto(AutoParkDao.getInstance().getAutos()),0,0);
        AutoParkDao.getInstance().getAutos().clear();
    }

    @Test
    public void countSumAutoInAutoParkTest_ListNullPointer(){
        List<Auto> autos = new ArrayList<>();
        autos.add(null);
        AutoParkDao.getInstance().countSumCostAuto(AutoParkDao.getInstance().getAutos());
        AutoParkDao.getInstance().getAutos().clear();
    }

    @Test
    public void findAutoBySpeedRangeTest_NullPointer(){
        Assert.assertTrue(AutoParkDao.getInstance().findAutoBySpeedRange(AutoParkDao.getInstance().getAutos(),500,300).isEmpty());
        AutoParkDao.getInstance().getAutos().clear();
    }

    @Test
    public void findAutoBySpeedRangeTest_ListNullPointer(){
        List<Auto> autos = new ArrayList<>();
        autos.add(null);
        AutoParkDao.getInstance().findAutoBySpeedRange(autos,500,300);
        AutoParkDao.getInstance().getAutos().clear();
    }

    @Test
    public void addAutoInListTest_NullValue(){
        AutoParkDao.getInstance().addInAutopark(null);
        Assert.assertTrue(AutoParkDao.getInstance().getAutos().isEmpty());
        AutoParkDao.getInstance().getAutos().clear();
    }


    @Test
    public void adads(){
        List<Double> doubleList = new ArrayList<>();
        doubleList.add(13.2);

        doubleList.stream().forEach(System.out::println);
    }


}
