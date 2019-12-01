package newVersion2;

public class Place {

    int id;

    volatile boolean empty = true;

    public Place(int id){
        this.id = id;
    }

}
