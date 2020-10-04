import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class CallCentr extends  Thread{

    int id;

    int counter = 0;

    App app;

    Lock locker = new ReentrantLock();

    public CallCentr(int id,App app){
        this.id = id;
        this.app = app;
    }


    @Override
    public void run() {
        try {
            while (counter < 4){
                while (counter < 4){
                    if(!app.getUserQueue().isEmpty()){
                        User user = app.getUserQueue().poll();
                        if(user != null){
                            tryHelp(user);
                        }
                    }
                }
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void tryHelp(User user) throws InterruptedException {
        sleep(100);
        user.calling = true;
        System.out.println(id + " - " + user.name);
        notify();
        app.getCallCentrQueue().remove(user);
    }


    public boolean tryHelp(String newId) throws InterruptedException {

        if(locker.tryLock()){
            sleep(100);
            System.out.println(id + " - " + newId);
            counter++;
            locker.unlock();
            return true;
        }
        return false;
    }

}
