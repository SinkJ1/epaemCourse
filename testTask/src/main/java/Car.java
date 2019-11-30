public class Car extends Thread {

    public String name;

    public boolean onParking;

    private boolean away;

    Parking place;

    private Program prog;

    public Car(String name, Program prog){
        this.name = name;
        this.prog = prog;
    }


    @Override
    public void run() {
        try {
            parking();
            if (onParking) {
                sleep(100);
                goAway();
                place.setCanParking(true);
            } else {
                waitPlace();
                if (!onParking) {
                   // goAway();
                  //  prog.getCarQueue().remove(this);
                }
            }
        }catch (InterruptedException e){

        }
    }

    private void waitPlace() throws InterruptedException {
        sleep(500);
    }

    private void goAway(){
        away = true;
        System.out.println("Car " + name + " away ");
    }

    private void swap(){

    }

    private void parking() throws InterruptedException {
        for(Parking parking : prog.getPlaceList()){
            if(parking.parking(this)){
                onParking = true;
                place = parking;
                break;
            }
        }
        if(!onParking) {
            System.out.println("Car " + name + " in queue");
            boolean offer = prog.getCarQueue().offer(this);
            if (!offer) {
                Thread.interrupted();
                throw new InterruptedException();
            }
        }
    }

    private int getWaitTime(){
        return 100 + (int) (Math.random() * 200);
    }

}

