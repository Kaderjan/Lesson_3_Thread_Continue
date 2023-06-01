package other.thread;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Executor {
    static int count=10;

    public static void main(String[] args) throws InterruptedException {
     //   testSome();
//        ExecutorService executor= Executors.newFixedThreadPool(2);
//
//        for (int i = 0; i < 5; i++) {
//            executor.submit(new Runnable() {
//                @Override
//                public void run() {
//                    System.out.println("ii");
//                }
//            });
//
//            executor.shutdown();
//        }

        CountDownLatch latch=new CountDownLatch(10);

        latch.countDown();





        Thread thread=new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 5; i++) {
                    latch.countDown();
                    Executor.decreement();
                }
            }
        });

        Thread thread1=new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 5; i++) {
                    latch.countDown();
                    Executor.decreement();
                }
            }
        });

        thread1.start();
        thread.start();
        Thread.sleep(4000);

        System.out.println(latch.getCount());
        System.out.println("count= "+count);
    }
    static void decreement(){
        count--;
    }

   }
