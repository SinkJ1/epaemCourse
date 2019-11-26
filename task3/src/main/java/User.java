
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
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
    }

    private void callToCentr() throws InterruptedException {
        for(CallCentr callCentr : app.getCallCentrqueue()){
            if(callCentr.tryHeal(name)){
                calling = true;
                break;
            }
        }
        if(!calling){
            app.getUserqueue().add(this);
            System.out.println(name + "is wait");
        }

    }

}
