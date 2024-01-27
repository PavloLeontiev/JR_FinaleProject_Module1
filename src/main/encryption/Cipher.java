package main.encryption;

import main.alphabet.Alphabet;

import java.io.IOException;

import static main.modes.CipherMode.BRUTE_FORCE;

public class Cipher extends UserData {

    public void execute() {
        try {
            char[] array = new char[1024];
            int bytesRead = reader.read(array);
            initializeAlphabet(alphabet, key, array, bytesRead);
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

    private void initializeAlphabet(Alphabet alphabet, String key, char[] array, int bytesRead) {
        cipherAlgorithm.setAlphabet(alphabet);
        int modifyKey = initializeKey(key, array, bytesRead);
        alphabet.initializeAlphabet(modifyKey);
        System.out.println(modifyKey);
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
