import java.util.Scanner;

public class GuessTheWord {

    private boolean play = true;
    private Words randomWord = new Words();
    private int rounds = 10;
    private char lastRound;
    private Scanner scanner = new Scanner(System.in);

    public void start() {

        do {
            playGame();
            askPlayAgain();
        } while (play);

        end();
    }

    private void playGame() {
        boolean gameRunning = true;

        while (gameRunning) {
            showWord();
            getInput();
            gameRunning = checkInput();
        }
    }

    private void showWord() {
        System.out.println("\nWord: " + randomWord);
        System.out.println("You have " + rounds + " tries left.");
    }

    private void getInput() {
        System.out.print("Enter a letter to guess the word: ");
        String userGuess = scanner.nextLine();
        lastRound = userGuess.charAt(0);
    }

    private boolean checkInput() {
        boolean isGuessedRight = randomWord.guess(lastRound);

        if (isGuessedRight) {
            if (randomWord.isGuessedRight()) {
                System.out.println("\nCongrats! You won! 🎉");
                System.out.println("The word was: " + randomWord);
                return false;
            }
        } else {
            rounds--;
            System.out.println("Wrong guess!");

            if (rounds == 0) {
                System.out.println("\nGame Over! 😢");
                return false;
            }
        }

        return true;
    }

    private void askPlayAgain() {
        System.out.print("\nDo you want to play again? (yes/no): ");
        String choice = scanner.nextLine();

        if (choice.equalsIgnoreCase("yes")) {
            randomWord = new Words();
            rounds = 10;
        } else {
            play = false;
        }
    }

    public void end() {
        scanner.close();
    }
}