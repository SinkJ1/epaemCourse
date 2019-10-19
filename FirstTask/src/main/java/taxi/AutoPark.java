package taxi;

import mainClass.Auto;

import java.util.ArrayList;
import java.util.List;

public class AutoPark {

    private List<Auto> autoPark = new ArrayList();

    public List<Auto> getAutoPark(){
        return autoPark;
    }

    public void addInAutoPark(Auto auto){
        autoPark.add(auto);
    }



}
