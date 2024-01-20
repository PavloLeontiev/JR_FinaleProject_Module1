package main.alphabet;

import java.util.HashMap;

public abstract class Alphabet {
    HashMap<Character, Character> alphabet = new HashMap<>();

    public abstract void initializeAlphabet(int key);

    public abstract HashMap<Character, Character> getAlphabet();
}

