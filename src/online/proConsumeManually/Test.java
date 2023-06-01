package online.proConsumeManually;

public class Test {

    public static void main(String[] args) throws InterruptedException {
        Processor process=new Processor();


        Thread thread=new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 20; i++) {
                    try {
                        process.consume();
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
            }
        });


        Thread thread1=new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    process.produce();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        });


        thread1.start();
        thread.start();


        thread.join();
        thread1.join();
    }
}
