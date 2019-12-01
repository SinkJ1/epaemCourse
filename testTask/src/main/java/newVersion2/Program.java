package newVersion2;

public class Program {

    public static void main(String[] args) {
        Place place = new Place();

        for(int i = 0; i < 5; i++){
            new Car(place);
        }

    }

}
