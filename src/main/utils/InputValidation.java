package main.utils;

import static main.utils.Mode.*;
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
        userData.setMode(initializeMode());
        userData.setFilePath(filepath);
        userData.setKey(Integer.parseInt(key));
    }

    private Mode initializeMode(){
        Mode chooseMode = null;
        switch (mode){
            case "ENCRYPT" : chooseMode = Mode.ENCRYPT;
                break;
            case "DECRYPT" : chooseMode = Mode.DECRYPT;
                break;
            case "BRUTE_FORCE" : chooseMode = Mode.BRUTE_FORCE;
                break;
            default: throw new IllegalArgumentException("Choose MODE from this list: ENCRYPT/DECRYPT/BRUTE_FORCE");
        }
        return chooseMode;
    }
}
