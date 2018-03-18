import java.util.concurrent.Semaphore;

public class Main {
    private static volatile Semaphore qcd = new Semaphore(1);


    public static void main(String[] args) {
	// write your code her


    }

    public static void ordering(){
        System.out.println(Thread.currentThread().getName() + "is ordering.");

    }

    public static void cooking(){
        System.out.println(Thread.currentThread().getName() + "is being cooked");
    }

    public static void handOver(){
        System.out.println(Thread.currentThread().getName() + "is being handed over.");
    }

    new Thread

}
