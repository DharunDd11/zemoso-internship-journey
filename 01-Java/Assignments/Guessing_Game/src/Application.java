public class Application {
    public static void main(String[] args) {
        GuessTheWord game = new GuessTheWord();
        game.start();
    }
}
/*
Player guesses a random word letter by letter

Rules:
→ 10 tries to guess the word
→ Correct guess fills in the letter
→ Wrong guess decreases tries
→ Guess all letters = You Win!
→ Tries reach 0 = Game Over!

3 classes:
→ Application.java    = entry point
→ Words.java          = word logic
→ GuessTheWord.java   = game loop
 */