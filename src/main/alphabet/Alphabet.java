package main.alphabet;

import java.util.*;

public abstract class Alphabet {
    private static ArrayList<Alphabet> alphabets = new ArrayList<>(
            Arrays.asList(new EnglishAlphabet(), new UkrainianAlphabet())
    );
    private int numberOfLetters;
    private char[] uppercaseUkrainianAlphabetArray;
    private char[] lowercaseUkrainianAlphabetArray;
    private final LinkedHashMap<Character, Character> alphabetCapitalLetters = new LinkedHashMap<>();
    private final LinkedHashMap<Character, Character> alphabetSmallLetters = new LinkedHashMap<>();

    public abstract void initializeAlphabet(int key);

    public abstract HashMap<Character, Character> getAlphabetCapitalLetters();

    public abstract HashMap<Character, Character> getAlphabetSmallLetters();

    public boolean isLetter(char ch) {
        if (alphabetCapitalLetters.containsKey(ch)) return true;
        else if (alphabetSmallLetters.containsKey(ch)) return true;
        else return false;
    }

    public boolean isUpperCase(char ch) {
        return alphabetCapitalLetters.containsKey(ch);
    }

    public boolean isLowerCase(char ch) {
        return alphabetSmallLetters.containsKey(ch);
    }

    public int getNumberOfLetters() {
        return numberOfLetters;
    }

    public static ArrayList<Alphabet> getAlphabets() {
        return alphabets;
    }
}

