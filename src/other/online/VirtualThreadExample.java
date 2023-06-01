package other.online;

public class VirtualThreadExample {

    public static void main(String[] args) {

        Runnable runnable=()->{
            for (int i = 0; i < 10; i++) {
                System.out.println("index: "+i);
            }
        };

        Thread thread=new Thread(runnable);

    }
}
