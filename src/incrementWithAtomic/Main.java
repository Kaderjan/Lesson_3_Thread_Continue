package incrementWithAtomic;

import java.util.concurrent.atomic.AtomicInteger;

public class Main {
    public static void main(String[] args) {


        AtomicInteger integer=new AtomicInteger(0);

        Thread thread=new Thread(new Increement(integer,5));

        Thread thread1=new Thread(new Increement(integer,10,true));

//        for (int i = 0; i < 10; i++) {
//            thread1.start();
//            thread.start();
//        }

        for (int i = 0; i < 10; i++) {

            new Thread(new Increement(integer,5)).start();
            new Thread(new Increement(integer,10,true)).start();
        }

        System.out.println("integer.get() = " + integer.get());


        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }


    }
}
class Increement implements Runnable{

    private AtomicInteger atomicInteger;
    int delta;
    boolean isSub;

    public Increement(AtomicInteger atomicInteger, int delta, boolean isSub) {
        this.atomicInteger = atomicInteger;
        this.delta = delta;
        this.isSub = isSub;
    }

    public Increement(AtomicInteger atomicInteger, int delta) {
        this.atomicInteger = atomicInteger;
        this.delta = delta;
    }

    @Override
    public void run() {
       // atomicInteger.incrementAndGet();
        if(isSub)
          delta*=-1;
        atomicInteger.addAndGet(delta);

    }
}

