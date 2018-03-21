import java.util.concurrent.Semaphore;
class PersonConstructor extends Thread{
    public static volatile boolean isOrdering = false;
    public static volatile boolean isCooking = false;
    Semaphore personSem;
    public String letter;
    PersonConstructor(String letter, Semaphore personSem){
        this.letter = letter;
        this.personSem = personSem;
    }

@Override
    public void run(){
        try {
            if (letter.equals("PersonA") && isOrdering == false && isCooking == false) {
                personSem.acquire();
                System.out.println(letter + " is reading and placing pizza in the oven");
                isOrdering = true;
                personSem.release();
            }else if(letter.equals("PersonB") && isOrdering == true && isCooking == false){
                try {
                    personSem.acquire();
                    System.out.println(letter + " is checking the pizza and handing the pizza over to person C");
                    isCooking = true;
                } catch (InterruptedException e1) {
                    e1.printStackTrace();
                }personSem.release();
            }else if(letter.equals("PersonC") && isCooking == true && isOrdering == true) {
                try {
                    personSem.acquire();
                    System.out.println(letter + " is delivering the pizza.");
                } catch (InterruptedException e1) {
                    e1.printStackTrace();
                }personSem.release();
            }else{
               run();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
//        isOrdering = false;
//        isCooking = false;
//        isDelivering = false;

    }
}


public class Main  {
    public static Semaphore personSem = new Semaphore(1);
    public static void main(String[] args) throws InterruptedException {

        // write your code here
        PersonConstructor PersonA = new PersonConstructor("PersonA", personSem);
        PersonConstructor PersonB = new PersonConstructor("PersonB", personSem);
        PersonConstructor PersonC = new PersonConstructor("PersonC", personSem);

        PersonA.start();
        PersonB.start();
        PersonC.start();

        PersonA.join();
        PersonB.join();
        PersonC.join();


    }
}
