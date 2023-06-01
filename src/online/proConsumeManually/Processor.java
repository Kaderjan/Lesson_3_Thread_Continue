package online.proConsumeManually;

import javax.swing.*;
import java.util.*;

public class Processor {
private LinkedList<Integer> list=new LinkedList<>();
private final int LIMIT=10;
private Object lock=new Object();

    public void produce() throws InterruptedException {
//        synchronized (this){
//            System.out.println("producer thread is waiting ");
//            wait();
//            System.out.println("Resumed");
//
//        }
        int value=0;
        while (true){
            synchronized (lock){
                while (list.size()==LIMIT){
                    lock.wait();
                }
                list.add(value++);
                lock.notify();
            }

        }
    }

    public void consume() throws InterruptedException {
//        Scanner scanner=new Scanner(System.in);
//        Thread.sleep(2000);
//        synchronized (this){
//            System.out.println("Waiting for return key: ");
//            scanner.nextLine();
//            System.out.println("Return key pressed");
//            notify();
//        }
        Random random=new Random();
        while (true){
            synchronized (lock){
                while (list.size()==0){
                    lock.wait();
                }
                System.out.println("LIst size: "+list.size());
                int value=list.removeFirst();
                System.out.println("value is : "+value);
                lock.notify();
            }

            Thread.sleep(random.nextInt(1000));
        }
    }

    public static void main(String[] args) {
    }
}
