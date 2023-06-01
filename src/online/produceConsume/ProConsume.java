package online.produceConsume;

import java.util.Random;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class ProConsume {

    private static BlockingQueue<Integer> queue=new ArrayBlockingQueue<>(10);

    public static void main(String[] args) throws InterruptedException {

        Thread thread=new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    producer();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        });

        Thread thread1=new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    consumer();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        });

        thread.start();
        thread1.start();

        thread.join();
        thread1.join();
    }

    private static void producer() throws InterruptedException {
        Random random=new Random();
        while (true){
            queue.put(random.nextInt(100));
        }
    }

    private static void consumer() throws InterruptedException {
        Random random=new Random();
        while (true){
            Thread.sleep(100);
            if(random.nextInt(10)==0){
                Integer value=queue.take();
                System.out.println("taken value : "+value+" Queue size: "+queue.size());
            }
        }
    }

}
