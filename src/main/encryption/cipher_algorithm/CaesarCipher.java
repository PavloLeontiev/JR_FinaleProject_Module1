package main.encryption.cipher_algorithm;

import main.alphabet.Alphabet;

import java.util.HashMap;

public class CaesarCipher extends CipherAlgorithm{
    private int key;
    private HashMap<Character, Character> alphabetCapitalLetters;
    private HashMap<Character, Character> alphabetSmallLetters;
    private void initializeAlphabet(Alphabet alphabet, String sKey){
        alphabet.initializeAlphabet(Integer.parseInt(sKey));
        alphabetCapitalLetters = alphabet.getAlphabetCapitalLetters();
        alphabetSmallLetters = alphabet.getAlphabetSmallLetters();
    }

    @Override
    public byte[] encrypt(byte[] bytes, Alphabet alphabet, String sKey, int bytesRead) {
        byte currentByte = 0;
        byte[] encryptedBytes = new byte[bytes.length];

        initializeAlphabet(alphabet, sKey);

        for(int i = 0; i < bytesRead; i++){
            currentByte = bytes[i];
            if(Character.isLetter(currentByte)){
                if(Character.isUpperCase(currentByte)){
                    char currentChar = alphabetCapitalLetters.get((char)currentByte);
                    encryptedBytes[i] = (byte) currentChar;
                } else if(Character.isLowerCase(currentByte)){
                    char currentChar = alphabetSmallLetters.get((char)currentByte);
                    encryptedBytes[i] = (byte) currentChar;
                }
            } else {
                encryptedBytes[i] = currentByte;
            }
        }
        return encryptedBytes;
    }

    @Override
    public byte[] decrypt(byte[] bytes, Alphabet alphabet, String stringKey, int bytesRead) {
        String negativeKey = "-" + stringKey;
        return encrypt(bytes, alphabet, negativeKey, bytesRead);
    }
}
