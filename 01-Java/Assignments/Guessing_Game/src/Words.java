import java.util.Random;

public class Words {

    private String[] randomWords = {
            "animal", "happiness", "indefinite", "steady",
            "birthday", "jungle", "rainbow", "cricket",
            "mystery", "dolphin", "blanket", "silence",
            "journey", "freedom"
    };

    private String selectedWord;
    private char[] letters;
    private Random random = new Random();

    public Words() {
        selectedWord = randomWords[random.nextInt(randomWords.length)];
        letters = new char[selectedWord.length()];
    }

    public boolean guess(char letter) {
        boolean guessedRight = false;

        for (int i = 0; i < selectedWord.length(); i++) {
            if (letter == selectedWord.charAt(i)) {
                letters[i] = letter;
                guessedRight = true;
            }
        }
        return guessedRight;
    }

    public boolean isGuessedRight() {
        for (char letter : letters) {
            if (letter == '\0') return false;
        }
        return true;
    }

    @Override
    public String toString() {
        StringBuilder text = new StringBuilder();
        for (char letter : letters) {
            text.append(letter == '\0' ? '-' : letter);
            text.append(' ');
        }
        return text.toString();
    }
}