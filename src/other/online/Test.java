package other.online;

public class Test {
    public static void main(String[] args) throws InterruptedException {

//        Runnable runnable=() -> {
//            System.out.println("hii lambda");
//            System.out.println("hii lambda");
//        };
//
//
//        Thread thread=new Thread(runnable);
//        thread.start();
//
//        System.out.println("Thread.currentThread().getName() = " + Thread.currentThread().getName());
//        Thread thread1 = Thread.currentThread();
//        System.out.println("thread1.getState() = " + thread1.getState());
//        System.out.println("thread1.getPriority() = " + thread1.getPriority());
//

        OneThread thread=new OneThread();

        Thread thread1=new Thread(thread);

        thread1.start();

        Thread.sleep(5000);



        System.out.println("we are requesting to stop ");
        Thread.sleep(2000);
         thread.setStopped(true);

        Thread.sleep(2000);
        System.out.println("stopped");
    }
}

class OneThread implements Runnable{

    boolean isStopped=false;

    public void setStopped(boolean stopped) {
        isStopped = stopped;
    }

    @Override
    public void run() {

        while (!isStopped){
            System.out.println("------");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        System.out.println("request is being accepted ");
    }
}
