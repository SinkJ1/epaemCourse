package newVersion2;

public class Car {

    private Thread thread;

    private String name;

    Place place;

    public Car(Place place){
        thread = new Thread(() ->run());
        thread.start();
        this.place = place;
    }

    private void run(){
        try{
            if(place.empty){
                System.out.println("car "+ name );
            }else{
                thread.sleep(5);
                System.out.println("car sleep");
            }
        }catch (InterruptedException e){

        }
    }


}
