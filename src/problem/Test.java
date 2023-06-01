package problem;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class Test {
    public static void main(String[] args) throws InterruptedException {
        List<Philosopher> philosophers=new ArrayList<>();

        for(int i=0;i<5;i++){
            philosophers.add(new Philosopher(true,false,false,false));
        }

     CheckAndEat checkAndEat;
        Thread thread;
        int count=0;
        while (notAllEat(philosophers)){
            int i=0;
            for(int j=0;j<2;j++){
                if(i==0)
                    checkAndEat=new CheckAndEat(philosophers,i++);
                else checkAndEat=new CheckAndEat(philosophers,2);
                thread=new Thread(checkAndEat);
                thread.setDaemon(true);
                thread.start();
            }
            count++;
            /*
            if(count<4){
                int i=0;
               for(int j=0;j<2;j++){
                   if(i==0)
                    checkAndEat=new CheckAndEat(philosophers,i++);
                   else checkAndEat=new CheckAndEat(philosophers,2);
                   thread=new Thread(checkAndEat);
                   thread.setDaemon(true);
                   thread.start();
               }
               count++;
            }
            else if(count<7){
                int i=1;
                for(int j=0;j<2;j++){
                    if(i==1)
                        checkAndEat=new CheckAndEat(philosophers,i++);
                    else checkAndEat=new CheckAndEat(philosophers,4);
                    thread=new Thread(checkAndEat);
                    thread.setDaemon(true);
                    thread.start();
                }
                count++;
            }
            else if(count<11){
                    checkAndEat=new CheckAndEat(philosophers,3);
                    thread=new Thread(checkAndEat);
                    thread.setDaemon(true);
                    thread.start();
                count++;
            }
            System.out.println("count = " + count);
           TimeUnit.SECONDS.sleep(1);
           */
        }
       // TimeUnit.SECONDS.sleep(3);
    }

    private static boolean notAllEat(List<Philosopher> philosophers) {
        for (int i = 0; i < philosophers.size(); i++) {
            if(!philosophers.get(i).isDoesEat())
                return true;
        }
        System.out.println();
        System.out.println("All philophers have eaten !!!!!!!! ");
        return false;
    }
}

class CheckAndEat implements Runnable{
    private List<Philosopher> philosophers;
    private int index;

    public CheckAndEat(List<Philosopher> philosophers,int index) {
        this.philosophers = philosophers;
        this.index=index;
    }

    @Override
    public void run() {
        Philosopher philosopher;
        Philosopher helperPrev;
        int p;
            philosopher=philosophers.get(index);

            if(philosopher.isDoesEat())
                return;
            p=index-1;
            if(index-1<=-1){
                p=philosophers.size()-1;
            }
            helperPrev=philosophers.get(p);

            if(philosopher.isForkAvailable()){
                philosopher.setForkAvailable(false);
                if(!philosopher.isHasOneFork())
                 philosopher.setHasOneFork(true);
                else philosopher.setHasTwoFork(true);
                return;
            }
            if(helperPrev.isForkAvailable()){
                helperPrev.setForkAvailable(false);
                if(!philosopher.isHasOneFork())
                    philosopher.setHasOneFork(true);
                else philosopher.setHasTwoFork(true);
                return;
            }

            if(philosopher.isHasTwoFork()){
//                try {
//                    TimeUnit.SECONDS.sleep(2);
//                } catch (InterruptedException e) {
//                    throw new RuntimeException(e);
//                }
                System.out.println(index+" - philosopher has eaten  ");
                philosopher.setDoesEat(true);
                philosopher.setForkAvailable(true);
                helperPrev.setForkAvailable(true);
            }

            else if(philosopher.isHasOneFork()){
                System.out.println(index+"philosopher has thought");
                try {
                    TimeUnit.SECONDS.sleep(3);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                if(!philosopher.isDoesEat()){
                    philosopher.setForkAvailable(true);
                }
            }

    }
}
