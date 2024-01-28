package main.utils;

import main.cli.CLI;
import main.encryption.Cipher;

public class Menu {
    public static void validationCipherData(Cipher cipher, String[] args) {
        InputValidation.validation(cipher, args);
        if (cipher.getCipherMode() == null && cipher.getFilePathRead() == null) {
            String[] arg = CLI.getInputArgument();
            InputValidation.validation(cipher, arg);
        }
        FileHandler.fileValidation(cipher);
        NIOHandler.initializeFileStreams(cipher);
        AlphabetValidation.alphabetInitialize(cipher);
    }

    public static void openModifyFile(Cipher cipher) {
        CLI.openModifyFile(cipher.getFilePathWrite());
    }
}
