package main.alphabet;

import java.util.*;

public abstract class Alphabet {
    private static ArrayList<Alphabet> alphabets = new ArrayList<>(
            Arrays.asList(new EnglishAlphabet(), new UkrainianAlphabet())
    );

    public abstract LinkedHashMap<Character, Character> getAlphabetCapitalLetters();

    public abstract LinkedHashMap<Character, Character> getAlphabetSmallLetters();

    public abstract void initializeAlphabet(int key);

    public abstract boolean isLetter(char ch);

    public abstract boolean isUpperCase(char ch);

    public abstract boolean isLowerCase(char ch);

    public abstract int getNumberOfLetters();

    public static ArrayList<Alphabet> getAlphabets() {
        return alphabets;
    }
}

