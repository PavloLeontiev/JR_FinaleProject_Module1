package main.alphabet;

import java.util.*;

public abstract class Alphabet {
    private final static ArrayList<Alphabet> ALPHABETS = new ArrayList<>(
            Arrays.asList(new EnglishAlphabet(), new UkrainianAlphabet())
    );

    public abstract LinkedHashMap<Character, Character> getUPPERCASE_ALPHABET_LETTERS();

    public abstract LinkedHashMap<Character, Character> getLOWERCASE_ALPHABET_LETTERS();

    public abstract void initializeAlphabet(int key);

    public abstract boolean isLetter(char ch);

    public abstract boolean isUpperCase(char ch);

    public abstract boolean isLowerCase(char ch);

    public abstract int getLETTERS_IN_ALPHABET();

    public static ArrayList<Alphabet> getAlphabets() {
        return ALPHABETS;
    }

}

