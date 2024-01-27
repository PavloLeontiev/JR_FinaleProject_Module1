package main.encryption.cipher_algorithm;

import main.alphabet.Alphabet;

import java.util.HashMap;

public class VigenereCipher extends CipherAlgorithm {
    private Alphabet alphabet;

    @Override
    public char[] encrypt(char[] chars, int bytesRead) {
        return null;
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
        return 0;
    }

    @Override
    public int getDecryptKey(String key) {
        return 0;
    }

    @Override
    public int getBruteForceKey(char[] chars, int bytesRead) {
        return 0;
    }

    @Override
    public void setAlphabet(Alphabet alphabet) {
        this.alphabet = alphabet;
    }
}
