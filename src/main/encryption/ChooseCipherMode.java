package main.encryption;

import main.utils.UserData;

public class ChooseCipherMode {
    public static void execute(UserData userData){
        switch (userData.getCipherMode()){
            case ENCRYPT : Encryptor.execute(userData); break;
            case DECRYPT : new Decryptor(); break;
            case BRUTE_FORCE : throw null;
        }
    }
}
