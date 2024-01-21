package main.encryption.cipher_algorithm;

import main.alphabet.Alphabet;

import java.util.HashMap;

public class CaesarCipher extends CipherAlgorithm{
    private HashMap<Character, Character> alphabetCapitalLetters;
    private HashMap<Character, Character> alphabetSmallLetters;
    private void initializeAlphabet(Alphabet alphabet, String sKey){
        alphabet.initializeAlphabet(Integer.parseInt(sKey));
        alphabetCapitalLetters = alphabet.getAlphabetCapitalLetters();
        alphabetSmallLetters = alphabet.getAlphabetSmallLetters();
    }

    @Override
    public char[] encrypt(char[] bytes, Alphabet alphabet, String sKey, int bytesRead) {
        char currentByte = 0;
        char[] encryptedBytes = new char[bytes.length];

        initializeAlphabet(alphabet, sKey);

        for(int i = 0; i < bytesRead; i++){
            currentByte = bytes[i];
            if(alphabet.isLetter(currentByte)){
                if(alphabet.isUpperCase(currentByte)){
                    char currentChar = alphabetCapitalLetters.get(currentByte);
                    encryptedBytes[i] = currentChar;
                } else if(alphabet.isLowerCase(currentByte)){
                    char currentChar = alphabetSmallLetters.get(currentByte);
                    encryptedBytes[i] = currentChar;
                }
            } else {
                encryptedBytes[i] = currentByte;
            }
        }
        return encryptedBytes;
    }

    @Override
    public char[] decrypt(char[] bytes, Alphabet alphabet, String stringKey, int bytesRead) {
        int key = alphabet.getNumberOfLetters() - (Integer.parseInt(stringKey) % alphabet.getNumberOfLetters());
        return encrypt(bytes, alphabet, String.valueOf(key), bytesRead);
    }
}
