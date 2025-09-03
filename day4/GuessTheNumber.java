import java.util.Random;
import java.util.Scanner;

public class GuessTheNumber {
    int theNumber;
    int max;
    Scanner scanner = new Scanner(System.in);

    // constructor
    public GuessTheNumber() {
        Random rand = new Random();
        max=100;
        theNumber = Math.abs(rand.nextInt()) % (max + 1);
        

    }

    public void play() {
        while (true) {
            int move = scanner.nextInt();
            if (move > theNumber) {
                System.out.println("your num is too big");
            } else if (move < theNumber) {
                System.out.println("your num is too small");
            } else {
                System.out.println("you got it bro");
                break;
            }
        }
    }

    public static void howBigIsMyNumber(int x) {
        if (x >= 0 && x <= 10) {
            System.out.println("OUr num is pretty small");
        } else if (x >= 11 && x <= 100) {
            System.out.println("our num is big");
        } else {
            System.out.println("our num out of range");
        }
    }


    public static void main(String[] args) {
        GuessTheNumber guessGame=new GuessTheNumber();
        System.out.println("welcome to my game. try to guess the correct num" + "its between 0 and " +guessGame.max+ " inclusive. type a num to start");
        guessGame.play();
    }
}