package main.encryption.cipher_algorithm;

import main.alphabet.Alphabet;
import main.modes.CipherMode;

public class VigenereCipher extends CipherAlgorithm {
    private Alphabet alphabet;
    private int[] keyArray;

    @Override
    public char[] encrypt(char[] chars, int bytesRead) {
        char currentChar = 0;
        int currentIndexChar = 0;
        int currentKey = 0;
        int currentModifyKey = 0;
        char[] encryptedChars = new char[chars.length];
        for (int i = 0; i < bytesRead; i++) {
            currentChar = chars[i];
            currentKey = keyArray[i % (keyArray.length)];
            if (alphabet.isLetter(currentChar)) {
                char currentLetter;
                if (alphabet.isUpperCase(currentChar)) {
                    currentIndexChar = alphabet.getUPPERCASE_ENGLISH_ALPHABET_ARRAY().indexOf(currentChar);
                    currentModifyKey = (currentIndexChar + currentKey) % alphabet.getLETTERS_IN_ALPHABET();
                    currentLetter = alphabet.getUPPERCASE_ENGLISH_ALPHABET_ARRAY().get(currentModifyKey);
                    encryptedChars[i] = currentLetter;
                } else if (alphabet.isLowerCase(currentChar)) {
                    currentIndexChar = alphabet.getLOWERCASE_ENGLISH_ALPHABET_ARRAY().indexOf(currentChar);
                    currentModifyKey = (currentIndexChar + currentKey) % alphabet.getLETTERS_IN_ALPHABET();
                    currentLetter = alphabet.getLOWERCASE_ENGLISH_ALPHABET_ARRAY().get(currentModifyKey);
                    encryptedChars[i] = currentLetter;
                }
            } else {
                encryptedChars[i] = currentChar;
            }
        }
        return encryptedChars;
    }

    @Override
    public int getEncryptKey(String key) {
        int encryptKey = alphabet.getLOWERCASE_ENGLISH_ALPHABET_ARRAY().indexOf(key.toLowerCase().charAt(0));
        return encryptKey;
    }

    @Override
    public int getDecryptKey(String key) {
        int letterInAlphabet = alphabet.getLETTERS_IN_ALPHABET();
        int indexKey = alphabet.getLOWERCASE_ENGLISH_ALPHABET_ARRAY().indexOf(key.toLowerCase().charAt(0));
        int decryptKey = letterInAlphabet - indexKey;
        return decryptKey;
    }

    @Override
    public int getBruteForceKey(char[] chars, int bytesRead) {
        return 0;
    }

    @Override
    public void setAlphabet(Alphabet alphabet) {
        this.alphabet = alphabet;
    }

    public void initializeEncryptAlphabet(CipherAlgorithm cipherAlgorithm, CipherMode cipherMode,
                                          Alphabet alphabet, String key, char[] array, int bytesRead) {
        cipherAlgorithm.setAlphabet(alphabet);
        keyArray = initializeKey(cipherMode ,key);
    }

    private int[] initializeKey(CipherMode cipherMode ,String key) {
        int counter = 0;
        int[] keyArray = new int[key.length()];
        for(char ch : key.toCharArray()) {
            keyArray[counter++] = switch (cipherMode) {
                case ENCRYPT -> getEncryptKey(String.valueOf(ch));
                case DECRYPT -> getDecryptKey(String.valueOf(ch));
                case BRUTE_FORCE -> 0;
            };
        }
        return keyArray;
    }
}
