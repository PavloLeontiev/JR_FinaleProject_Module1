package main.alphabet;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public abstract class Alphabet {
    private static ArrayList<Alphabet> alphabets = new ArrayList<>(
            Arrays.asList(new EnglishAlphabet(), new UkrainianAlphabet())
    );
    private int numberOfLetters;
    public abstract void initializeAlphabet(int key);
    public abstract HashMap<Character, Character> getAlphabetCapitalLetters();
    public abstract HashMap<Character, Character> getAlphabetSmallLetters();
    public abstract boolean isLetter (char ch);
    public abstract boolean isUpperCase (char ch);
    public abstract boolean isLowerCase (char ch);
    public int getNumberOfLetters() {
        return numberOfLetters;
    }

    public static ArrayList<Alphabet> getAlphabets() {
        return alphabets;
    }
}

