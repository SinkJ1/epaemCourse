package dao;

import entity.Auto;
import entity.AutoPark;

import java.util.Comparator;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.stream.Collectors;

public class AutoParkDao {

    private static final Logger logger = LogManager.getLogger(AutoParkDao.class);
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
        try{
            autoPark.addInAutoPark(auto);
        }catch (NullPointerException npe){
            logger.warn(npe);
        }
    }

    public List<Auto> getAutos(){
        return autoPark.getAutoPark();
    }

    public List<Auto> sortByFuelConsumption(List<Auto> autos){
        try {
            return autos.stream()
                    .sorted(Comparator.comparingDouble(Auto::getFuelConsumption))
                    .collect(Collectors.toList());
        }catch(NullPointerException ex){
            logger.warn(ex);
            return null;
        }
    }

    public Double countSumCostAuto(List<Auto> autos){
        try{
            return  autos.stream()
                    .mapToDouble(Auto::getCost).sum();
        }catch(NullPointerException ex){
            logger.warn(ex);
            return null;
        }
    }

    public List<Auto> findAutoBySpeedRange(List<Auto> autos,int max,int min){
        try{
        return  autos.stream()
                .filter(s->s.getMaxSpeed() > min && s.getMaxSpeed() < max).collect(Collectors.toList());
        }catch(NullPointerException ex){
            logger.warn(ex);
            return null;
        }
    }

}
