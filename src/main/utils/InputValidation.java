package main.utils;

import main.utils.modes.AlgorithmMode;
import main.utils.modes.CipherMode;

public class InputValidation {
    private static InputValidation instance = null;
    private String mode;
    private String filepath;
    private String key;
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
                case 1 : filepath = args[i]; break;
                case 2 : key = args[i]; break;
                default: throw new ArrayIndexOutOfBoundsException();
            }
        }
    }

    private void initializeUserData(UserData userData){
        userData.setCipherMode(CipherMode.initializeMode(mode, userData));
        userData.setFilePath(filepath);
        userData.setKey(Integer.parseInt(key));
        userData.setAlgorithmMode(AlgorithmMode.CAESARCIPHER); // by default
    }

}
