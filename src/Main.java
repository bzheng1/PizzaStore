import java.util.concurrent.Semaphore;
class PersonConstructor{
    Semaphore personSem = new Semaphore(1);
    String letter;
    PersonConstructor(String letter, Semaphore personSem){
        this.letter = letter;
        this.personSem = personSem;
    }
}
public class Main {
    private static Semaphore personSem = new Semaphore(1);
    public static void main(String[] args) {
	// write your code her
        PersonConstructor PersonA = new PersonConstructor("PersonA", personSem);
        PersonConstructor PersonB = new PersonConstructor("PersonB", personSem);
        PersonConstructor PersonC = new PersonConstructor("PersonC", personSem);


    }
    public static void run(){
        try{
            personSem.acquire();
            ordering();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }finally {
            personSem.release();
        }
    }
    public static void ordering(){
        System.out.println(Thread.currentThread().getName() + " is being read and placed in oven.");
        personSem.release();
    }

    public static void handOver(){
        System.out.println(Thread.currentThread().getName() + "is being handed over to quality control.");
    }
    public static void finished(){
        System.out.println(Thread.currentThread().getName() + "is being handed over to customer.");
    }

}
