package main.utils;

import main.encryption.UserData;
import main.encryption.cipher_algorithm.CaesarCipher;
import main.encryption.cipher_algorithm.CipherAlgorithm;
import main.encryption.cipher_algorithm.VisenereCipher;
import main.modes.CipherMode;

public class InputValidation {
    public static void validation(UserData userData, String[] args) {
        for (int i = 0; i < args.length; i++) {
            switch (i) {
                case 0:
                    userData.setCipherMode(CipherMode.initializeMode(args[i]));
                    break;
                case 1:
                    userData.setFilePathRead(args[i]);
                    break;
                case 2:
                    userData.setCipherAlgorithm(validationAlgorithm(args[i]));
                    userData.setKey(args[i]);
                    break;
                default:
                    throw new ArrayIndexOutOfBoundsException();
            }
        }
    }


    private static CipherAlgorithm validationAlgorithm(String key) {
        if (key.matches("^[0-9]*$")) {
            return new CaesarCipher();
        } else if (key.matches("^[a-zA-Z]*$")) {
            return new VisenereCipher();
        } else {
            throw new IllegalArgumentException();
        }
    }

}
