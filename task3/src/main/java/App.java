import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class App {

    static BlockingQueue<User> userQueue = new ArrayBlockingQueue<>(20, true);
    static List<CallCentr> callCentrQueue = new ArrayList<>();

    public static void main(String[] args) {


        App app = new App();

        for(int i = 0; i < 2;i++){
            callCentrQueue.add(new CallCentr(i,app));
        }

        callCentrQueue.forEach(Thread::start);

        for(int i = 0; i < 10; i++){
            new User(i,"name" + i,app).start();
        }

    }

    public BlockingQueue<User> getUserQueue(){
        return userQueue;
    }

    public List<CallCentr> getCallCentrQueue() {
        return callCentrQueue;
    }
}
