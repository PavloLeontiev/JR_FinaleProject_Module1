package main.encryption.cipher_algorithm;

import main.alphabet.Alphabet;

public abstract class CipherAlgorithm {
    public abstract char[] encrypt(char[] chars, int bytesRead);

    public abstract char[] decrypt(char[] chars, int bytesRead);

    public abstract char[] brute_force(char[] chars, int bytesRead);

    public abstract int getEncryptKey(String key);

    public abstract int getDecryptKey(String key);

    public abstract int getBruteForceKey(char[] chars, int bytesRead);

    public abstract void setAlphabet(Alphabet alphabet);
}
