//we have to import a few things to generate a pseudorandom number and to handle inputs
import java.util.Scanner;
import java.util.Random;

public class Mastermind {
    public static void main(String[] args) {
        //This will give us a psuedorandom number to pull an item from the chosen array
        //effectively giving us a random word
        Random rand = new Random();
        //These scanners will handle input later on. You can, but should not recycle scanners if possible.
        //Furthermore, we're getting strings and ints. It's cleaner to just use different scanners.
        Scanner input = new Scanner(System.in);
        Scanner choice = new Scanner(System.in);
        //Typical var stuff.
        String guess;
        String chosenWord = "";
        int usrChoice;
        int guesses = 4;
        int correctLetters = 0, correctCounter = 0;
        int size = 0;
        int randN = rand.nextInt(5);
        String easyWords[];
        easyWords = new String[5];
        String medWords[];
        medWords = new String[5];
        String hardWords[];
        hardWords = new String[5];
        String vHardWords[];
        vHardWords = new String[5];
        char correctGuesses[];
        easyWords[0] = "tune";
        easyWords[1] = "bald";
        easyWords[2] = "unit";
        easyWords[3] = "care";
        easyWords[4] = "slab";
        medWords[0] = "steward";
        medWords[1] = "diamond";
        medWords[2] = "seminar";
        medWords[3] = "central";
        medWords[4] = "council";
        hardWords[0] = "vegetarian";
        hardWords[1] = "particular";
        hardWords[2] = "acceptance";
        hardWords[3] = "background";
        hardWords[4] = "relinquish";
        vHardWords[0] = "concentration";
        vHardWords[1] = "communication";
        vHardWords[2] = "embarrassment";
        vHardWords[3] = "demonstration";
        vHardWords[4] = "constellation";

        //We're asking the user for input and getting that input via Scanner.
        System.out.println("What difficulty would you like? (0 = Easy, 1 = Intermediate, 2 = Hard, 3 = Very Hard)");
        usrChoice = choice.nextInt();

        //This will get a random word from the relevant array,
        //make the array I use to display correct guesses the appropriate size,
        //and give the user a hint as to how long the word will be.
        if(usrChoice == 0){
            chosenWord = easyWords[randN];
            size = 4;
            for(int i = 0; i < 5; ++i)
                System.out.println(easyWords[i]);
        } else if(usrChoice == 1) {
            chosenWord = medWords[randN];
            size = 7;
            for(int i = 0; i < 5; ++i)
                System.out.println(medWords[i]);
        } else if(usrChoice == 2) {
            chosenWord = hardWords[randN];
            size = 10;
            for(int i = 0; i < 5; ++i)
                System.out.println(hardWords[i]);
        } else if(usrChoice == 3) {
            chosenWord = vHardWords[randN];
            size = 13;
            for(int i = 0; i < 5; ++i)
                System.out.println(vHardWords[i]);
        }


            //This will allow us to set the array we use for guesses to the appropriate size.
            //Regardless of size of word chosen.
            correctGuesses = new char[size];

        while(guesses > 0) {
            //We're just getting user's guess here.
            System.out.println("\nGuess? (" + guesses + " left)" + " and " + correctLetters + " letters correct.");
            guess = input.next();

            //This helps keep the winning condition honest. 
            correctCounter = 0;

            //This makes it easier to display correct guesses in their place of the chosen word.
            for(int i = 0; i < guess.length(); ++i) {
                if(guess.charAt(i) == chosenWord.charAt(i)) {
                    ++correctCounter;
                    //This stops the array from giving away the word if you have not merely guessed a correct letter
                    //that previously was incorrect.
                    if(correctCounter > correctLetters)
                        correctGuesses[i] = chosenWord.charAt(i);
                } else {
                    //This stops the array from being cleared out everytime you haven't gotten the answer right the first time.
                    if(correctGuesses[i] == '\0')
                        correctGuesses[i] = '_';
                }
            }
                //If the word you guess has as many correct letters in the same spot as the chosen word then you win. This is why we
                //set the variable to 0. To try and minimize false positives. 
                if(correctCounter != chosenWord.length()) {
                    --guesses;
                } else {
                    System.out.println("Congratulations!");
                    break;
                }

                //Just an easy way of iterating through the correct guesses array and displaying the contents.
                for(int i = 0; i < size; ++i)
                    System.out.print(correctGuesses[i] + " ");
            
                //This allows me to keep the correct guess count, change it only if it improves, and trigger the game winning 
                //condition in the event of a fully correct guess.
                if(correctCounter > 0 || correctCounter > correctLetters)
                    correctLetters = correctCounter;
        }

    }
}
