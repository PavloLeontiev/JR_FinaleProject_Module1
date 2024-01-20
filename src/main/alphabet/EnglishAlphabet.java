package main.alphabet;

import java.util.HashMap;

public class EnglishAlphabet extends Alphabet{
    private final HashMap<Character, Character> alphabetCapitalLetters = new HashMap<>();
    private final HashMap<Character, Character> alphabetSmallLetters = new HashMap<>();
    public HashMap<Character, Character> getAlphabetCapitalLetters(){
        return alphabetCapitalLetters;
    }
    public HashMap<Character, Character> getAlphabetSmallLetters(){
        return alphabetSmallLetters;
    }
    public void initializeAlphabet(int key){
        initializeAlphabetCapitalLetters(key);
        initializeAlphabetSmallLetters(key);
    }

    private void initializeAlphabetCapitalLetters(int key){
        int modifyChar = 0;
        int firstByteAlphabet = 65;
        int lastByteAlphabet = 90;
        int consistLetters = 26;
        for (int i = 1; i <= consistLetters; i++) {
            modifyChar = firstByteAlphabet + key;
            alphabetCapitalLetters.put((char)firstByteAlphabet,
                    (char)(modifyChar > lastByteAlphabet ? modifyChar % lastByteAlphabet + 64 : modifyChar));
            firstByteAlphabet++;
        }
    }
    private void initializeAlphabetSmallLetters(int key){
        int modifyChar = 0;
        int firstByteAlphabet = 97;
        int lastByteAlphabet = 122;
        int consistLetters = 26;

        for (int i = 1; i <= consistLetters; i++, firstByteAlphabet++) {
            modifyChar = (char)firstByteAlphabet + key;
            alphabetSmallLetters.put((char)firstByteAlphabet,
                    (char)(modifyChar > lastByteAlphabet ? modifyChar % lastByteAlphabet + 96 : modifyChar));
        }

    }
}
