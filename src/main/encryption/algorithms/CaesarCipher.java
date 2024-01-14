package main.encryption.algorithms;

import main.utils.InputValidation;

public class CaesarCipher extends Algorithm{
    private static CaesarCipher instance = null;
    private CaesarCipher(){}

    public static CaesarCipher getInstance(){
        if (instance == null){
            instance = new CaesarCipher();
        }
        return instance;
    }

}
