package main.encryption.cipher_algorithm;

import main.alphabet.Alphabet;

public abstract class CipherAlgorithm {
    public abstract char[] encrypt(char[] chars, Alphabet alphabet, String stringKey, int bytesRead);

    public abstract char[] decrypt(char[] chars, Alphabet alphabet, String stringKey, int bytesRead);

}
