import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class App {

    static BlockingQueue<User> Userqueue = new ArrayBlockingQueue<>(20, true);
    static List<CallCentr> CallCentrqueue = new ArrayList<>();

    public static void main(String[] args) {


        App app = new App();
        for(int i = 0; i < 2;i++){
            CallCentrqueue.add(new CallCentr(i,app));
        }

        CallCentrqueue.forEach(Thread::start);

        for(int i = 0; i < 10; i++){
            new User(i,"name" + i,app).start();
        }

    }

    public BlockingQueue<User> getUserqueue(){
        return Userqueue;
    }

    public List<CallCentr> getCallCentrqueue() {
        return CallCentrqueue;
    }
}
