package main.utils;

import main.encryption.UserData;
import main.encryption.cipher_algorithm.CaesarCipher;
import main.encryption.cipher_algorithm.CipherAlgorithm;
import main.encryption.cipher_algorithm.VisenereCipher;
import main.modes.CipherMode;

public class InputValidation {
    private final static int COMMAND_ARGUMENT = 0;
    private final static int FILE_PATH_ARGUMENT = 1;
    private final static int KEY_ARGUMENT = 2;

    public static void validation(UserData userData, String[] args) {
        for (int i = 0; i < args.length; i++) {
            switch (i) {
                case COMMAND_ARGUMENT:
                    userData.setCipherMode(CipherMode.initializeMode(args[i]));
                    break;
                case FILE_PATH_ARGUMENT:
                    userData.setFilePathRead(FileHandler.checkFileExisting(args[i]));
                    break;
                case KEY_ARGUMENT:
                    userData.setCipherAlgorithm(validationAlgorithm(args[i], userData.getCipherMode()));
                    userData.setKey(args[i]);
                    break;
                default:
                    throw new ArrayIndexOutOfBoundsException();
            }
        }
    }


    private static CipherAlgorithm validationAlgorithm(String key, CipherMode mode) {
        if (mode == CipherMode.ENCRYPT || mode == CipherMode.DECRYPT) {
            if (key.matches("^[0-9]*$")) {
                return new CaesarCipher();
            } else if (key.matches("^[a-zA-Z]*$")) {
                return new VisenereCipher();
            } else {
                throw new IllegalArgumentException();
            }
        } else if (mode == CipherMode.BRUTE_FORCE) {
            if (key.equalsIgnoreCase("CaesarCipher")) {
                return new CaesarCipher();
            } else if (key.equalsIgnoreCase("VisenereCipher")) {
                return new VisenereCipher();
            } else if (key == null) {
                return new CaesarCipher(); // by default
            } else {
                throw new IllegalArgumentException();
            }
        }
        return null;
    }

}
