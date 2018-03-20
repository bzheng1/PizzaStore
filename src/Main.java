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
            if (letter.equals("PersonA")) {
                personSem.acquire();
                System.out.println(letter + " is reading and placing pizza in the oven");
            }else if(letter.equals("PersonB")) {
                try {
                    personSem.acquire();
                    System.out.println(letter + " is checking the pizza and handing the pizza over to person B");
                } catch (InterruptedException e1) {
                    e1.printStackTrace();
                }personSem.release();
            }else if(letter.equals("PersonC")) {
                try {
                    personSem.acquire();
                    System.out.println(letter + " is delivering the pizza.");
                } catch (InterruptedException e1) {
                    e1.printStackTrace();
                }
            }personSem.release();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }personSem.release();
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
