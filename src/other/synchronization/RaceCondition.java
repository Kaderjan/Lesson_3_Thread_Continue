package other.synchronization;

import java.util.Random;
import java.util.concurrent.TimeUnit;

public class RaceCondition implements Runnable{

    private int count=0;


    @Override
    public  void run() {
        for (int i = 0; i < 10; i++) {
            count++;
        }
    }

    public int getCount(){
        return count;
    }
    public static void main(String[] args) throws InterruptedException {

       RaceCondition condition=new RaceCondition();

       Thread thread=new Thread(condition);
       Thread thread1=new Thread(condition);

        thread.start();
        thread1.start();

       Thread.sleep(1000);

        System.out.println("condition.getCount() = " + condition.getCount());
    }


}

