package dao;

import mainClass.Auto;
import taksi.AutoPark;

import java.util.List;

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

}
