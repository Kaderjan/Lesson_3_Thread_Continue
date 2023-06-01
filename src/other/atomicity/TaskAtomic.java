package other.atomicity;


import java.util.concurrent.atomic.AtomicInteger;

public class TaskAtomic implements Runnable {

    private  final AtomicInteger number;

    public TaskAtomic() {
        this.number=new AtomicInteger();
    }

    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            number.set(i);
        }
    }
}


