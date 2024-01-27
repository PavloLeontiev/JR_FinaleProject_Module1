package main.utils;

import main.encryption.CipherData;
import main.exception.FileAlreadyExistsException;
import main.exception.FileNotFoundException;
import main.modes.CipherMode;

import java.io.File;
import java.io.IOException;

public class FileHandler {

    public static void fileValidation(CipherData cipherData) {
        cipherData.setFilePathWrite(initializeFileNameWrite(cipherData.getCipherMode(), cipherData.getFilePathRead()));
        createFile(cipherData.getFilePathWrite());
    }

    public static String checkFileExisting(String filePath) {
        File file = new File(filePath);
        if (!file.exists())
            throw new FileNotFoundException(filePath);
        return filePath;
    }

    private static String initializeFileNameWrite(CipherMode cipherMode, String fileRead) {
        String mode = switch (cipherMode) {
            case ENCRYPT -> fileNameEncrypt(fileRead);
            case DECRYPT, BRUTE_FORCE -> fileNameDecrypt(fileRead);
        };
        return mode;
    }

    private static String fileNameEncrypt(String fileRead) {
        int index = fileRead.lastIndexOf('.');
        String fileWrite = fileRead.substring(0, index) + "[ENCRYPTED]" + fileRead.substring(index);
        return fileWrite;
    }

    private static String fileNameDecrypt(String fileRead) {
        int firstIndex = fileRead.lastIndexOf('[');
        int lastIndex = fileRead.lastIndexOf(']');
        String fileWrite = fileRead.substring(0, firstIndex) + "[DECRYPTED]" + fileRead.substring(lastIndex + 1);
        return fileWrite;
    }

    private static void createFile(String filePath) {
        File file = new File(filePath);
        try {
            if (!file.createNewFile()) throw new FileAlreadyExistsException(filePath);
        } catch (IOException e) {
            throw new FileAlreadyExistsException(filePath);
        }
    }
}
