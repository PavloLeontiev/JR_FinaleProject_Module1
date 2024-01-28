package main.encryption;

import main.alphabet.Alphabet;

import java.io.IOException;

public class Cipher extends CipherData {

    public void execute() {
        try {
            char[] array = new char[bufferCapacity];
            int bytesRead = reader.read(array);
            cipherAlgorithm.initializeEncryptAlphabet(cipherAlgorithm, cipherMode, alphabet, key, array, bytesRead);
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
}
