package start;

import auto.Nissan;
import auto.Volkswagen;
import dao.AutoParkDao;
import mainClass.Auto;
import mainClass.BodyType1;
import mainClass.BodyType2;

import java.util.ArrayList;
import java.util.List;

public class Program {
    public static void main(String[] args){

        BodyType2 nissan = new Nissan(1,"nissan",123.2,1234,123);
        BodyType2 nissan2 = new Nissan(1,"nissan1",126.2,1233,123);
        BodyType2 nissan3 = new Nissan(1,"nissan2",123.2,1234,123);
        BodyType2 nissan4 = new Nissan(1,"nissan3",128.2,1230,123);
        BodyType2 nissan5 = new Nissan(1,"nissan4",122.2,1234,123);
        BodyType1 nissan6 = new Volkswagen(1,"nissan4",124.2,1234,123);

        List<Auto> list = new ArrayList();
        list.add(nissan);
        list.add(nissan2);
        list.add(nissan3);
        list.add(nissan4);
        list.add(nissan5);
        list.add(nissan6);



      AutoParkDao.getInstance().sortByFuelConsumption(list).stream().forEach(System.out::println);



    }

}
