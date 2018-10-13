import java.util.Scanner;
import java.util.Random;

public class Mastermind {
    public static void main(String[] args) {
        //create a random object so we can get a random number for the array
        Random rand = new Random();
        //scanners are how Java handles input
        Scanner input = new Scanner(System.in);
        Scanner choice = new Scanner(System.in);
        //Nothing special, setting up arrays and variables
        String guess;
        String chosenWord = "";
        int usrChoice;
        int guesses = 4;
        int correctLetters = 0;
        int randN = rand.nextInt(5);
        String easyWords[];
        easyWords = new String[5];
        String medWords[];
        medWords = new String[5];
        String hardWords[];
        hardWords = new String[5];
        String vHardWords[];
        vHardWords = new String[5];
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

        //Allow the user to choose their poison. I didn't feel like dealing with strings, so choice is in integer.
        System.out.println("What difficulty would you like? (0 = Easy, 1 = Intermediate, 2 = Hard, 3 = Very Hard)");
        usrChoice = choice.nextInt();
    
        //This is so that the word the user has to guess will be appropriate to the difficulty chosen.
        if(usrChoice == 0){
            chosenWord = easyWords[randN];
        } else if(usrChoice == 1) {
            chosenWord = medWords[randN];
        } else if(usrChoice == 2) {
            chosenWord = hardWords[randN];
        } else if(usrChoice == 3) {
            chosenWord = vHardWords[randN];
        }

        //We want to end the game if the user hasn't guessed the word in 4 tries. 
        //This will also let the user know how many guesses they have left and how many letters they got correct.
        //The instructions were lenient in terms of information given to the player/user.
        while(guesses > 0) {
            System.out.println("Guess? (" + guesses + " left)" + " and " + correctLetters + " letters correct.");
            guess = input.next();

            //This compares the strings between the word chosen by the random number generator
            //and the user inputs as their guess. It will tell them how many letters they got right.
            for(int i = 0; i < guess.length(); ++i) {
                if(guess.charAt(i) == chosenWord.charAt(i)) {
                    ++correctLetters;
                }
            }
                //This will terminate if in 4 tries they fail to guess the letter.
                //While it's not the best winning condition I think it's sufficient here.
                if(correctLetters != chosenWord.length()) {
                    --guesses;
                } else {
                    System.out.println("Congratulations!");
                    break;
                }
        }

    }
}
