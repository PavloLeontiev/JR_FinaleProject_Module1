package main.utils;

import main.encryption.Cipher;
import main.utils.AlphabetValidation;
import main.utils.FileHandler;
import main.utils.InputValidation;
import main.utils.NIOHandler;

public class Menu {
    public static void validationCipherData(Cipher cipher, String[] args) {
        InputValidation.validation(cipher, args);
        FileHandler.fileValidation(cipher);
        NIOHandler.initializeFileStreams(cipher);
        AlphabetValidation.alphabetInitialize(cipher);
    }
}
