package online.produceConsume;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class Test {

    public static void main(String[] args) {
        BlockingQueue<Integer> block=new ArrayBlockingQueue<>(12);

        block.add(12);
        block.add(12);
        block.add(12);
        block.add(12);



        Thread thread=new Thread(new Runnable() {
            @Override
            public void run() {
            }
        });
    }
}
