
public class User extends Thread{

    private int id;

    public String name;

    public boolean calling = false;

    App app;

    public User(int id, String name, App app) {
        this.id = id;
        this.name = name;
        this.app = app;
    }

    @Override
    public void run() {

            try {
                callToCentr();
                    if(calling == false){
                        sleep(100);
                        if(calling == false){
                            System.out.println(this.name + "get out");
                            app.getUserQueue().remove(this);
                        }
                    }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
    }

    private void callToCentr() throws InterruptedException {
        for(CallCentr callCentr : app.getCallCentrQueue()){
            if(callCentr.tryHelp(name)){
                calling = true;
                break;
            }
        }
        if(!calling){
            app.getUserQueue().add(this);
            System.out.println(name + "is wait");
        }

    }

}
