import java.util.concurrent.Semaphore;
class PersonConstructor extends Thread{
    Semaphore personSem = new Semaphore(1);
    public String letter;
    PersonConstructor(String letter, Semaphore personSem){
        this.letter = letter;
        this.personSem = personSem;
    }


@Override
public void run(){
    try {
        System.out.println(letter + "is reading and placing pizza in the oven");
    }finally {

    }
}
}


public class Main  {
    public static Semaphore personSem = new Semaphore(1);
    public static void main(String[] args) {
        // write your code here
        PersonConstructor PersonA = new PersonConstructor("PersonA", personSem);
        PersonConstructor PersonB = new PersonConstructor("PersonB", personSem);
        PersonConstructor PersonC = new PersonConstructor("PersonC", personSem);

    }


//    public static void ordering(){
//        System.out.println(" is being read and placed in oven.");
//        personSem.release();
//    }
//
//    public static void handOver(){
//        System.out.println(Thread.currentThread().getName() + "is being handed over to quality control.");
//    }
//    public static void finished(){
//        System.out.println(Thread.currentThread().getName() + "is being handed over to customer.");
//    }

}
