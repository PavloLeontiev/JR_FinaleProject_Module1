package main.encryption;

import main.alphabet.Alphabet;

import java.io.IOException;

public class Cipher extends CipherData {

    public void execute() {
        try {
            char[] array = new char[bufferCapacity];
            int bytesRead = reader.read(array);
            initializeEncryptAlphabet(alphabet, key, array, bytesRead);
            while (bytesRead != -1) {
                array = cipherAlgorithm.encrypt(array, bytesRead);
                writer.write(array, 0, bytesRead);
                writer.flush();
                bytesRead = reader.read(array);
            }
            fileReader.close();
            fileWriter.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

    private void initializeEncryptAlphabet(Alphabet alphabet, String key, char[] array, int bytesRead) {
        cipherAlgorithm.setAlphabet(alphabet);
        int modifyKey = initializeKey(key, array, bytesRead);
        alphabet.initializeAlphabet(modifyKey);
    }

    private int initializeKey(String key, char[] chars, int bytesRead) {
        int modifyKey = switch (cipherMode) {
            case ENCRYPT -> cipherAlgorithm.getEncryptKey(key);
            case DECRYPT -> cipherAlgorithm.getDecryptKey(key);
            case BRUTE_FORCE -> cipherAlgorithm.getBruteForceKey(chars, bytesRead);
        };
        return modifyKey;
    }
}
