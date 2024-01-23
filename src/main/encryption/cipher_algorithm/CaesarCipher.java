package main.encryption.cipher_algorithm;

import main.alphabet.Alphabet;

import java.util.LinkedHashMap;

public class CaesarCipher extends CipherAlgorithm {
    private LinkedHashMap<Character, Character> UPPERCASE_ALPHABET_LETTERS;
    private LinkedHashMap<Character, Character> LOWERCASE_ALPHABET_LETTERS;

    private void initializeAlphabet(Alphabet alphabet, String sKey) {
        alphabet.initializeAlphabet(Integer.parseInt(sKey));
        UPPERCASE_ALPHABET_LETTERS = alphabet.getUPPERCASE_ALPHABET_LETTERS();
        LOWERCASE_ALPHABET_LETTERS = alphabet.getLOWERCASE_ALPHABET_LETTERS();
    }

    @Override
    public char[] encrypt(char[] chars, Alphabet alphabet, String key, int bytesRead) {
        char currentChar = 0;
        char[] encryptedChars = new char[chars.length];

        initializeAlphabet(alphabet, key);

        for (int i = 0; i < bytesRead; i++) {
            currentChar = chars[i];
            if (alphabet.isLetter(currentChar)) {
                char currentLetter;
                if (alphabet.isUpperCase(currentChar)) {
                    currentLetter = UPPERCASE_ALPHABET_LETTERS.get(currentChar);
                    encryptedChars[i] = currentLetter;
                } else if (alphabet.isLowerCase(currentChar)) {
                    currentLetter = LOWERCASE_ALPHABET_LETTERS.get(currentChar);
                    encryptedChars[i] = currentLetter;
                }
            } else {
                encryptedChars[i] = currentChar;
            }
        }
        return encryptedChars;
    }

    @Override
    public char[] decrypt(char[] chars, Alphabet alphabet, String stringKey, int bytesRead) {
        int key = alphabet.getLETTERS_IN_ALPHABET() - (Integer.parseInt(stringKey) % alphabet.getLETTERS_IN_ALPHABET());
        return encrypt(chars, alphabet, String.valueOf(key), bytesRead);
    }

}
