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
                    if(!app.getUserqueue().isEmpty()){
                        User user = app.getUserqueue().poll();

                        if(user != null){
                            tryHeal(user);
                        }
                    }
                }
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void tryHeal(User user) throws InterruptedException {
        sleep(100);
        user.calling = true;
        System.out.println(id + " - " + user.name);
        app.getCallCentrqueue().remove(user);
    }


    public boolean tryHeal(String newId) throws InterruptedException {

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
