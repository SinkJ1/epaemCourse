package newVersion2;

import java.util.concurrent.atomic.AtomicBoolean;

public class Place {

    int id;

    public volatile AtomicBoolean empty;

    public void setEmpty(AtomicBoolean empty) {
        this.empty = empty;
    }

    public Place(int id){
        this.id = id;
    }

}
