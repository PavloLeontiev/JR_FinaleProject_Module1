package main.utils;

import main.alphabet.Alphabet;
import main.encryption.UserData;

import java.io.*;
import java.util.ArrayList;

public class AlphabetValidation {
    ArrayList<Alphabet> alphabets = Alphabet.getAlphabets();

    public static void alphabetInitialize(UserData userData){
        ArrayList<Alphabet> alphabets = Alphabet.getAlphabets();
        alphabets.get(0).initializeAlphabet(0);
        alphabets.get(1).initializeAlphabet(0);
        userData.setAlphabet(
                validationContent(alphabets, userData.getFileReader(), userData.getReader()
                )
        );
    }

    private static Alphabet validationContent(ArrayList<Alphabet> alphabets, FileReader fileReader, BufferedReader reader){
        try {
            char[] array = new char[128];
            int numberOfEnglishLetters = 0;
            int numberOfUkrainianLetters = 0;
            reader.mark(128);
            reader.read(array);
            reader.reset();
            for(char ch : array){
                if(alphabets.get(0).isLetter(ch)) // EnglishAlphabet
                    numberOfEnglishLetters++;
                else if(alphabets.get(1).isLetter(ch)) // UkrainianAlphabet
                    numberOfUkrainianLetters++;
            }
            if(numberOfEnglishLetters > numberOfUkrainianLetters) {
                return alphabets.get(0); // EnglishAlphabet
            } else {
                return alphabets.get(1); // UkrainianAlphabet
            }

        } catch (IOException e){
            System.out.println(e);
        }
        return null;
    }
}
