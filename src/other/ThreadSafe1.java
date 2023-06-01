package other;


import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import java.util.concurrent.TimeUnit;



public class ThreadSafe1 {
    public static void main(String[] args) throws InterruptedException {

        List<Integer> set1 = new ArrayList<>();

        var set = Collections.synchronizedList(set1);
        Runnable runnable1= ()->{
            for (int i = 0; i < 500; i++) {
                try {
                    Thread.sleep(1);
                    set.add(i);
                } catch (InterruptedException e) {
                   throw new RuntimeException();
                }
            }
        };


        Thread th1 = new Thread(runnable1);
        th1.start();
        th1.join();
        TimeUnit.SECONDS.sleep(5);
        System.out.println("size = "+set.size());

        Runnable runnable2= ()->{
            for (int i = 0; i < 500; i++) {
                try {
                    Thread.sleep(1);
                    System.out.println(set.get(i));
                } catch (InterruptedException e) {
                    throw new RuntimeException();
                }
            }
        };

       Thread th2 = new Thread(runnable2);
       th2.start();
       th2.join();
       Runnable runnable3= ()->{
            for (int i = 0; i < 500; i++) {
                try {
                    Thread.sleep(1);
                    set.set(i,5);
                    System.out.println(Thread.currentThread().getName()+" :: "+set.get(i));
                } catch (InterruptedException e) {
                    throw new RuntimeException();
                }
            }
        };
        Thread th3 = new Thread(runnable3);
        th3.start();
        th3.join();
        System.out.println("ArrayList size = "+set.size());

        Runnable runnable4= ()->{
            for (int i = 0; i < 500; i++) {
                try {
                    Thread.sleep(1);
                    if(set.size()>i)
                     System.out.println(set.remove(i));

                } catch (InterruptedException e) {
                    throw new RuntimeException();
                }
            }
        };
        Thread th4 = new Thread(runnable4);
        th4.start();
        th4.join();
        TimeUnit.SECONDS.sleep(5);

        System.out.println("Array size = "+set.size());


    }
}