package start;

import auto.Nissan;
import auto.Volkswagen;
import dao.AutoParkDao;
import mainClass.Auto;

public class Program {
    public static void main(String[] args){

        Nissan nissanQashqai = new Nissan(1,"nissan qashqai",100,250,1233.50);
        Volkswagen volkswagenPolo = new Volkswagen(2,"volksvagen polo",25,300,5000.78);

        AutoParkDao.getInstance().addInAutopark(nissanQashqai);
        AutoParkDao.getInstance().addInAutopark(volkswagenPolo);

        AutoParkDao.getInstance().getAutos().stream().map(Auto::getCost).forEach(System.out::println);
    }

}
