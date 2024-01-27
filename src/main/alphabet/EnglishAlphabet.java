package main.alphabet;

import java.util.*;

public class EnglishAlphabet extends Alphabet {
    public EnglishAlphabet() {
        initializeAlphabet(0);
    }
    private final int LETTERS_IN_ALPHABET = 26;
    private final char[] UPPERCASE_ENGLISH_ALPHABET_ARRAY = {
            'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M',
            'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z'
    };
    private final char[] LOWERCASE_ENGLISH_ALPHABET_ARRAY = {
            'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm',
            'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z'
    };
    private final ArrayList<String> FREQUENTLY_USED_WORDS = new ArrayList<>(Arrays.asList(
            "the", "and", "to", "of", "in", "is", "it", "you", "that",
            "he", "was", "for", "on", "are", "with", "as", "his", "they", "be",
            "at", "one", "have", "this", "from", "or", "had", "by", "but", "some",
            "what", "there", "we", "can", "out", "other", "were", "all", "your",
            "when", "up", "use", "how", "said", "an", "each", "she", "which", "do"
    ));
    private final LinkedHashMap<Character, Character> UPPERCASE_ALPHABET_LETTERS = new LinkedHashMap<>();
    private final LinkedHashMap<Character, Character> LOWERCASE_ALPHABET_LETTERS = new LinkedHashMap<>();

    public void initializeAlphabet(int key) {
        initializeAlphabetCapitalLetters(key);
        initializeAlphabetSmallLetters(key);
    }

    private void initializeAlphabetCapitalLetters(int key) {
        char[] alphabet = UPPERCASE_ENGLISH_ALPHABET_ARRAY;
        int modifyIndex = 0;
        for (int i = 0; i < LETTERS_IN_ALPHABET; i++) {
            modifyIndex = i + key;
            UPPERCASE_ALPHABET_LETTERS.put(alphabet[i], modifyIndex >= LETTERS_IN_ALPHABET ?
                    alphabet[modifyIndex % LETTERS_IN_ALPHABET] : alphabet[modifyIndex]);
        }
    }

    private void initializeAlphabetSmallLetters(int key) {
        char[] alphabet = LOWERCASE_ENGLISH_ALPHABET_ARRAY;
        int modifyIndex = 0;
        for (int i = 0; i < LETTERS_IN_ALPHABET; i++) {
            modifyIndex = i + key;
            LOWERCASE_ALPHABET_LETTERS.put(alphabet[i], modifyIndex >= LETTERS_IN_ALPHABET ?
                    alphabet[modifyIndex % LETTERS_IN_ALPHABET] : alphabet[modifyIndex]);
        }
    }

    public boolean isLetter(char ch) {
        if (UPPERCASE_ALPHABET_LETTERS.containsKey(ch)) return true;
        else if (LOWERCASE_ALPHABET_LETTERS.containsKey(ch)) return true;
        else return false;
    }

    public boolean isUpperCase(char ch) {
        return UPPERCASE_ALPHABET_LETTERS.containsKey(ch);
    }

    public boolean isLowerCase(char ch) {
        return LOWERCASE_ALPHABET_LETTERS.containsKey(ch);
    }

    public LinkedHashMap<Character, Character> getUPPERCASE_ALPHABET_LETTERS() {
        return UPPERCASE_ALPHABET_LETTERS;
    }

    public LinkedHashMap<Character, Character> getLOWERCASE_ALPHABET_LETTERS() {
        return LOWERCASE_ALPHABET_LETTERS;
    }

    public int getLETTERS_IN_ALPHABET() {
        return LETTERS_IN_ALPHABET;
    }

    public ArrayList<String> getFREQUENTLY_USED_WORDS() {
        return FREQUENTLY_USED_WORDS;
    }
}
