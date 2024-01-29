package main.utils;

import main.encryption.CipherData;
import main.encryption.cipher_algorithm.CaesarCipher;
import main.encryption.cipher_algorithm.CipherAlgorithm;
import main.encryption.cipher_algorithm.VigenereCipher;
import main.modes.CipherMode;

public class InputValidation {
    private final static int COMMAND_ARGUMENT = 0;
    private final static int FILE_PATH_ARGUMENT = 1;
    private final static int KEY_ARGUMENT = 2;

    public static void validation(CipherData cipherData, String[] args) {
        for (int i = 0; i < args.length; i++) {
            switch (i) {
                case COMMAND_ARGUMENT:
                    cipherData.setCipherMode(CipherMode.initializeMode(args[i]));
                    break;
                case FILE_PATH_ARGUMENT:
                    cipherData.setFilePathRead(FileHandler.checkFileExisting(args[i]));
                    break;
                case KEY_ARGUMENT:
                    cipherData.setCipherAlgorithm(validationAlgorithm(args[i], cipherData.getCipherMode()));
                    cipherData.setKey(args[i]);
                    break;
                default:
                    throw new ArrayIndexOutOfBoundsException();
            }
        }
    }


    private static CipherAlgorithm validationAlgorithm(String key, CipherMode mode) {
        System.out.println(key);
        if (mode == CipherMode.ENCRYPT || mode == CipherMode.DECRYPT) {
            if (key.matches("^[0-9]*$")) {
                return new CaesarCipher();
            } else if (key.matches("^[a-zA-Zа-яА-ЯІіЇїЄєҐґ]*$")) {
                return new VigenereCipher();
            } else {
                throw new IllegalArgumentException();
            }
        } else if (mode == CipherMode.BRUTE_FORCE) {
            if (key.equalsIgnoreCase("Caesar")) {
                return new CaesarCipher();
            } else if (key.equalsIgnoreCase("Vigenere")) {
                return new VigenereCipher();
            } else {
                return new CaesarCipher(); // by default
            }
        }
        return null;
    }

}
