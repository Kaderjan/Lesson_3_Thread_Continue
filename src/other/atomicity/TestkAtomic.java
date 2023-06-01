package other.atomicity;

import java.util.Date;

public class TestkAtomic {
    public static void main(String[] args) {

     TaskAtomic atomicTask=new TaskAtomic();

     TaskLock taskLock=new TaskLock();

     int numberThreads=50;

     Thread[] threads=new Thread[numberThreads];

        Date begin,end;

        begin=new Date();


        for (int i = 0; i < numberThreads; i++) {
            threads[i]=new Thread(taskLock);
            threads[i].start();
        }

        for (int i = 0; i < numberThreads; i++) {
            try {
                threads[i].join();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
         end=new Date();

    System.out.println("Main: Lock Results : "+(end.getTime()-begin.getTime()));


        Thread[] threads2=new Thread[numberThreads];

        Date begin2,end2;

        begin2=new Date();


        for (int i = 0; i < numberThreads; i++) {
            threads2[i]=new Thread(atomicTask);
            threads2[i].start();
        }

        for (int i = 0; i < numberThreads; i++) {
            try {
                threads2[i].join();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        end2=new Date();

        System.out.println("Main: Atomic Results : "+(end2.getTime()-begin2.getTime()));

    }
}


