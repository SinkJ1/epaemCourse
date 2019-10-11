package dao;

import mainClass.Auto;
import taksi.AutoPark;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class AutoParkDao {

    private static AutoParkDao instance;
    private AutoPark autoPark = new AutoPark();


    private AutoParkDao(){

    }

    public static AutoParkDao getInstance(){
        if(instance == null){
            instance = new AutoParkDao();
        }
        return instance;
    }

    public void addInAutopark(Auto auto){
        autoPark.addInAutoPark(auto);
    }

    public List<Auto> getAutos(){
        return autoPark.getAutoPark();
    }

    public List<Auto> sortByFuelConsumption(List<Auto> autos){
        return autos.stream()
                .sorted(Comparator.comparingDouble(Auto::getFuelConsumption))
                .collect(Collectors.toList());
    }

    public Double countSumCostAuto(List<Auto> autos){
        return  autos.stream()
                .mapToDouble(i->i.getCost()).sum();
    }

    public List<Auto> findAutoBySpeedRange(List<Auto> autos,int max,int min){
        return  autos.stream()
                .filter(s->s.getMaxSpeed() > min && s.getMaxSpeed() < max).collect(Collectors.toList());
    }

}
