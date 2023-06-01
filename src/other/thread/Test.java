package other.thread;

import java.util.Scanner;

public class Test {
    public static void main(String[] args) {

        Process proces=new Process();

        proces.start();

        System.out.println("press enter to stop : ");
        new Scanner(System.in).nextLine();
        proces.shutDown();
    }
}

class Process extends Thread{
    boolean isConti=true;
    @Override
    public void run() {
        while(isConti) {
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println(" hiii ");
        }
        }

        public void shutDown(){
        isConti=false;
        }
    }

