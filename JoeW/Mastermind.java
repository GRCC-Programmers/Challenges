import java.util.Scanner;
import java.util.Random;

public class Mastermind {
    public static void main(String[] args) {
        Random rand = new Random();
        Scanner input = new Scanner(System.in);
        Scanner choice = new Scanner(System.in);
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

        System.out.println("What difficulty would you like? (0 = Easy, 1 = Intermediate, 2 = Hard, 3 = Very Hard)");
        usrChoice = choice.nextInt();

        if(usrChoice == 0){
            chosenWord = easyWords[randN];
        } else if(usrChoice == 1) {
            chosenWord = medWords[randN];
        } else if(usrChoice == 2) {
            chosenWord = hardWords[randN];
        } else if(usrChoice == 3) {
            chosenWord = vHardWords[randN];
        }

        while(guesses > 0) {
            System.out.println("Guess? (" + guesses + " left)" + " and " + correctLetters + " letters correct.");
            guess = input.next();

            for(int i = 0; i < guess.length(); ++i) {
                if(guess.charAt(i) == chosenWord.charAt(i)) {
                    ++correctLetters;
                }
            }
                if(correctLetters != chosenWord.length()) {
                    --guesses;
                } else {
                    System.out.println("Congratulations!");
                    break;
                }
        }

    }
}
