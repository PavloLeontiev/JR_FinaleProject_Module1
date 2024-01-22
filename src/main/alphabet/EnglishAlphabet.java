package main.alphabet;

import java.util.HashMap;
import java.util.LinkedHashMap;

public class EnglishAlphabet extends Alphabet {
    private final int numberOfLetters = 26;
    private char[] uppercaseEnglishAlphabetArray = {
            'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M',
            'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z'
    };
    private char[] lowercaseEnglishAlphabetArray = {
            'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm',
            'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z'
    };
    private final LinkedHashMap<Character, Character> alphabetCapitalLetters = new LinkedHashMap<>();
    private final LinkedHashMap<Character, Character> alphabetSmallLetters = new LinkedHashMap<>();

    public LinkedHashMap<Character, Character> getAlphabetCapitalLetters() {
        return alphabetCapitalLetters;
    }

    public LinkedHashMap<Character, Character> getAlphabetSmallLetters() {
        return alphabetSmallLetters;
    }

    public void initializeAlphabet(int key) {
        initializeAlphabetCapitalLetters(key);
        initializeAlphabetSmallLetters(key);
    }

    private void initializeAlphabetCapitalLetters(int key) {
        char[] alphabet = uppercaseEnglishAlphabetArray;
        int modifyIndex = 0;
        for (int i = 0; i < 26; i++) {
            modifyIndex = i + key;
            alphabetCapitalLetters.put(alphabet[i], modifyIndex >= 26 ? alphabet[modifyIndex % 26] : alphabet[modifyIndex]);
        }
    }

    private void initializeAlphabetSmallLetters(int key) {
        char[] alphabet = lowercaseEnglishAlphabetArray;
        int modifyIndex = 0;
        for (int i = 0; i < 26; i++) {
            modifyIndex = i + key;
            alphabetSmallLetters.put(alphabet[i], modifyIndex >= 26 ? alphabet[modifyIndex % 26] : alphabet[modifyIndex]);
        }
    }
}
