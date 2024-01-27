package main.encryption.cipher_algorithm;

import main.alphabet.Alphabet;
import main.modes.CipherMode;

public class VisenereCipher extends CipherAlgorithm {
    private Alphabet alphabet;

    @Override
    public char[] encrypt(char[] chars, int bytesRead) {
        return new char[0];
    }

    @Override
    public char[] decrypt(char[] chars, int bytesRead) {
        return new char[0];
    }

    @Override
    public char[] brute_force(char[] chars, int bytesRead) {
        return new char[0];
    }

    public void setAlphabet(Alphabet alphabet) {
    }

    public int getEncryptKey(String key) {
        return 0;
    }

    public int getDecryptKey(String key) {
        return 0;
    }

    public int getBruteForceKey(char[] chars, int bytesRead) {
        return 0;
    }
}
