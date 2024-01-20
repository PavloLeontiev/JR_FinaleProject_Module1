package main.encryption.cipher_algorithm;

import main.alphabet.Alphabet;
import main.encryption.UserData;

public class CaesarCipher extends CipherAlgorithm{

    @Override
    public byte[] encrypt(byte[] bytes, Alphabet alphabet, String stringKey, int bytesRead) {
        int key = Integer.parseInt(stringKey);
        int lengthByteArray = bytes.length;
        byte currentByte = 0;
        byte[] encryptedBytes = new byte[lengthByteArray];

        alphabet.initializeAlphabet(key);

        for(int i = 0; i < bytesRead; i++){
            currentByte = bytes[i];
            if(alphabet.getAlphabet().containsKey((char)currentByte)) {
                char ch = alphabet.getAlphabet().get((char) currentByte);
                encryptedBytes[i] = (byte) ch;
            } else {
                encryptedBytes[i] = currentByte;
            }
        }
        return encryptedBytes;
    }

    @Override
    public byte[] decrypt(byte[] bytes, Alphabet alphabet, String stringKey, int bytesRead) {
        int key = -Integer.parseInt(stringKey);
        int lengthByteArray = bytes.length;
        byte currentByte = 0;
        byte[] encryptedBytes = new byte[lengthByteArray];

        alphabet.initializeAlphabet(key);

        for(int i = 0; i < bytesRead; i++){
            currentByte = bytes[i];
            if(alphabet.getAlphabet().containsKey((char)currentByte)) {
                char ch = alphabet.getAlphabet().get((char) currentByte);
                encryptedBytes[i] = (byte) ch;
            } else {
                encryptedBytes[i] = currentByte;
            }
        }
        return encryptedBytes;
    }
}
