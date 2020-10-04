package newVersion2;

import java.util.concurrent.atomic.AtomicBoolean;

public class Place {

    private int id;

    private volatile AtomicBoolean empty;

    public void setEmpty(AtomicBoolean empty) {
        this.empty = empty;
    }

    public Place(int id){
        this.id = id;
    }

    public AtomicBoolean getEmpty(){
        return  empty;
    }

    public int getId() {
        return id;
    }
}
