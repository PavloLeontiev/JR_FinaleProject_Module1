package main.utils;

import main.alphabet.Alphabet;
import main.encryption.UserData;

import java.io.*;
import java.util.ArrayList;

public class AlphabetValidation {
    ArrayList<Alphabet> alphabets = Alphabet.getAlphabets();
    private static final int capacity = 128;
    private static final int ENGLISH_ALPHABET = 0;
    private static final int UKRAINIAN_ALPHABET = 1;

    public static void alphabetInitialize(UserData userData) {
        ArrayList<Alphabet> alphabets = Alphabet.getAlphabets();
        alphabets.get(ENGLISH_ALPHABET).initializeAlphabet(0);
        alphabets.get(UKRAINIAN_ALPHABET).initializeAlphabet(0);
        userData.setAlphabet(
                validationContent(alphabets, userData.getFileReader(), userData.getReader()
                )
        );
    }

    private static Alphabet validationContent(ArrayList<Alphabet> alphabets, FileReader fileReader, BufferedReader reader) {

        try {
            char[] array = new char[capacity];
            int numberOfEnglishLetters = 0;
            int numberOfUkrainianLetters = 0;
            reader.mark(capacity);
            reader.read(array);
            reader.reset();
            for (char ch : array) {
                if (alphabets.get(ENGLISH_ALPHABET).isLetter(ch)) {
                    numberOfEnglishLetters++;
                } else if (alphabets.get(UKRAINIAN_ALPHABET).isLetter(ch)) { // UkrainianAlphabet
                    numberOfUkrainianLetters++;
                }
            }
            if (numberOfEnglishLetters > numberOfUkrainianLetters) {
                return alphabets.get(ENGLISH_ALPHABET); // EnglishAlphabet
            } else {
                return alphabets.get(UKRAINIAN_ALPHABET); // UkrainianAlphabet
            }

        } catch (IOException e) {
            System.out.println(e);
        }
        return null;
    }

}
