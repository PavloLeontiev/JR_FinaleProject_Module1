package main.encryption.cipher_algorithm;

import main.alphabet.Alphabet;

public abstract class CipherAlgorithm {
    public abstract byte[] encrypt(byte[] bytes, Alphabet alphabet, String stringKey, int bytesRead);

    public abstract byte[] decrypt(byte[] bytes, Alphabet alphabet, String stringKey, int bytesRead);
}
