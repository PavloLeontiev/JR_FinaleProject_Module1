package main.encryption.cipher_algorithm;

import main.alphabet.Alphabet;
import main.modes.CipherMode;

import java.util.HashMap;
import java.util.LinkedHashMap;

public class CaesarCipher extends CipherAlgorithm {
    private Alphabet alphabet;

    @Override
    public char[] encrypt(char[] chars, int bytesRead) {
        char currentChar = 0;
        char[] encryptedChars = new char[chars.length];
        for (int i = 0; i < bytesRead; i++) {
            currentChar = chars[i];
            if (alphabet.isLetter(currentChar)) {
                char currentLetter;
                if (alphabet.isUpperCase(currentChar)) {
                    currentLetter = alphabet.getUPPERCASE_ALPHABET_LETTERS().get(currentChar);
                    encryptedChars[i] = currentLetter;
                } else if (alphabet.isLowerCase(currentChar)) {
                    currentLetter = alphabet.getLOWERCASE_ALPHABET_LETTERS().get(currentChar);
                    encryptedChars[i] = currentLetter;
                }
            } else {
                encryptedChars[i] = currentChar;
            }
        }
        return encryptedChars;
    }

    @Override
    public char[] decrypt(char[] chars, int bytesRead) {
        return encrypt(chars, bytesRead);
    }

    @Override
    public char[] brute_force(char[] chars, int bytesRead) {
        return encrypt(chars, bytesRead);
    }

    @Override
    public int getEncryptKey(String key) {
        int encryptKey = Integer.parseInt(key) % alphabet.getLETTERS_IN_ALPHABET();
        return encryptKey;
    }

    @Override
    public int getDecryptKey(String key) {
        int decryptKey = alphabet.getLETTERS_IN_ALPHABET() - (Integer.parseInt(key) % alphabet.getLETTERS_IN_ALPHABET());
        return decryptKey;
    }

    @Override
    public int getBruteForceKey(char[] chars, int bytesRead) {
        HashMap<Integer, Integer> keySearch = new HashMap();

        for (int key = 1; key < alphabet.getLETTERS_IN_ALPHABET(); key++) {
            int numberOfCoincidences = 0;
            alphabet.initializeAlphabet(key);
            char[] decryptedChars = encrypt(chars, bytesRead);
            String[] wordsOfText = String.valueOf(decryptedChars).split(" ");
            for (int j = 0; j < wordsOfText.length; j++) {
                if (alphabet.getFREQUENTLY_USED_WORDS().contains(wordsOfText[j].toLowerCase())) {
                    numberOfCoincidences++;
                }
            }
            keySearch.put(key, numberOfCoincidences);
        }

        int suitableKey = 0;
        int maxCoincidences = 0;
        for (int key : keySearch.keySet()) {
            int coincidences = keySearch.get(key);
            if (coincidences > maxCoincidences) {
                maxCoincidences = coincidences;
                suitableKey = key;
            }
        }
        return suitableKey;
    }

    @Override
    public void setAlphabet(Alphabet alphabet) {
        this.alphabet = alphabet;
    }
}
