import java.util.Random;
import java.util.Scanner;

// the class is the blue print of the game
// basically saying to java, this is what a game looks like
// it has attributes like theNumber and max
// it has behaviors like play() and howBigIsMyNumber()
// it has a constructor that sets up each new game instance/object
// we can create as many game instances/objects as we want
// each game instance/object has its own theNumber and max


public class GuessTheNumber {
    int theNumber;
    int max;
    // to read user input

    Scanner scanner = new Scanner(System.in);

    // constructor, sets up each new game instance/object
    // generates a random number between 0 and max
    // every time we create a new game, we get a new random number
    // the constructor has no return type
    public GuessTheNumber() {
        Random rand = new Random();
        max=100;
        theNumber = Math.abs(rand.nextInt()) % (max + 1);
        

    }
    // play() isnt a static method bc it needs to access instance variables like theNumber and scanner
    // which are unique to each game instance/object
    // so we need to create an instance of the class to call this method
    public void play() { // void means it doesn't return anything
        while (true) {
            // handling input validation
            boolean wrongInput = scanner.hasNextInt();
            if (!wrongInput){
                System.out.println("that is not a valid input, try again");
                scanner.next(); // clear the invalid input
                continue; // go back to the start of the loop
            // handling out of range value
            }else if(theNumber >= 0 && theNumber<=100 ){
                System.out.println("thats outa range bud, try again");
                scanner.next();
            }
            int move = scanner.nextInt(); // read user input creating a variable move to store the input
            //bc everything from scanner is a string, we need to convert it to an int and .nextIn does that
            // we can use Integer.parseInt(scanner.nextLine()) to do the same thing

            if (move > theNumber) { // if user input is greater than theNumber
                System.out.println("your num is too big");
            } else if (move < theNumber) {
                System.out.println("your num is too small");
            } else {
                System.out.println("you got it bro");
                break;
            }
        }
    }
    // static means we can call this method without creating an instance of the class bc
    // it belongs to the class itself not to any particular instance of the class
    // this means we can call this method like GuessTheNumber.howBigIsMyNumber(5);
    // if it wasn't static, we would have to create an instance of the class first like
    // GuessTheNumber game = new GuessTheNumber();
    // game.howBigIsMyNumber(5);
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
        GuessTheNumber.howBigIsMyNumber(5);
    }
}