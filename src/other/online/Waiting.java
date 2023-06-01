package other.online;

public class Waiting {

    public static void main(String[] args) {

        Runnable runnable=()->{
            for (int i = 0; i < 5; i++) {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                System.out.println("Running ");
            }
        };


        Thread thread=new Thread(runnable);
      thread.setDaemon(true);
        thread.start();

        try {
            thread.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }


    }
}


