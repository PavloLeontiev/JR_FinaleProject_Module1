package main.utils;

import java.io.File;
import java.io.IOException;

public class FileHandler {
    public static boolean checkFileExisting(UserData userData){
        File file = new File(userData.getFilePath());
        return file.exists();
    }

    public static boolean createFile(UserData userData) {
        File file = new File(userData.getFilePath()+"DECRYPTED");
        try {
            return file.createNewFile();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
