package main.utils;

import main.alphabet.Alphabet;
import main.encryption.CipherData;

import java.io.*;
import java.util.ArrayList;

public class AlphabetValidation {
    private static final int ENGLISH_ALPHABET = 0;
    private static final int UKRAINIAN_ALPHABET = 1;
    private static Alphabet english;
    private static Alphabet ukrainian;

    public static void alphabetInitialize(CipherData cipherData) {
        ArrayList<Alphabet> alphabets = Alphabet.getAlphabets();
        english = alphabets.get(ENGLISH_ALPHABET);
        ukrainian = alphabets.get(UKRAINIAN_ALPHABET);
        cipherData.setAlphabet(validationContent(alphabets, cipherData.getReader(), cipherData.getBufferCapacity()));
    }

    private static Alphabet validationContent(ArrayList<Alphabet> alphabets, BufferedReader reader, int capacity) {
        try {
            char[] array = new char[capacity];
            int numberOfEnglishLetters = 0;
            int numberOfUkrainianLetters = 0;
            reader.mark(capacity);
            reader.read(array);
            reader.reset();
            for (char ch : array) {
                if (english.isLetter(ch)) {
                    numberOfEnglishLetters++;
                } else if (ukrainian.isLetter(ch)) {
                    numberOfUkrainianLetters++;
                }
            }
            if (numberOfEnglishLetters > numberOfUkrainianLetters) {
                return english;
            } else {
                return ukrainian;
            }

        } catch (IOException e) {
            System.out.println(e);
        }
        return null;
    }

}
