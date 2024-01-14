package main.utils;

import main.encryption.algorithms.CaesarCipher;
import main.utils.modes.CipherMode;

public class InputValidation {
    private String mode;
    private String filePath;
    private String key;
    private static InputValidation instance = null;
    private InputValidation(){}

    public static InputValidation getInstance(){
        if (instance == null){
            instance = new InputValidation();
        }
        return instance;
    }
    public void validation(UserData userData, String[] args){
        initializeFields(args);
        initializeUserData(userData);
    }

    private void initializeFields(String[] args){
        for (int i = 0; i < args.length; i++) {
            switch (i) {
                case 0 : mode = args[i]; break;
                case 1 : filePath = args[i]; break;
                case 2 : key = args[i]; break;
                default: throw new ArrayIndexOutOfBoundsException();
            }
        }
    }

    private void initializeUserData(UserData userData){
        userData.setCipherMode(CipherMode.initializeMode(mode, userData));
        userData.setFilePathRead(filePath);
        userData.setKey(Integer.parseInt(key));
        userData.setAlgorithm(CaesarCipher.getInstance()); // by default
    }

}
