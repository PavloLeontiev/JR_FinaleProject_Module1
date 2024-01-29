package main.encryption.cipher_algorithm;

import main.alphabet.Alphabet;
import main.modes.CipherMode;

public abstract class CipherAlgorithm {
    public abstract char[] encrypt(char[] chars, int bytesRead);

    public abstract int getEncryptKey(String key);

    public abstract int getDecryptKey(String key);

    public abstract int getBruteForceKey(char[] chars, int bytesRead);

    public abstract void setAlphabet(Alphabet alphabet);

    public abstract void initializeEncryptAlphabet(CipherAlgorithm cipherAlgorithm, CipherMode cipherMode,
                                                   Alphabet alphabet, String key, char[] array, int bytesRead);
}
