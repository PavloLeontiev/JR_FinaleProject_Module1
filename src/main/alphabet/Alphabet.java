package main.alphabet;

import java.util.HashMap;

public abstract class Alphabet {
    public abstract void initializeAlphabet(int key);
    public abstract HashMap<Character, Character> getAlphabetCapitalLetters();
    public abstract HashMap<Character, Character> getAlphabetSmallLetters();

}

