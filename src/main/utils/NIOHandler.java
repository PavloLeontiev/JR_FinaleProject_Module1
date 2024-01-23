package main.utils;

import main.encryption.UserData;
import main.exception.*;
import main.exception.FileNotFoundException;

import java.io.*;

public class NIOHandler {

    public static void initializeFileStreams(UserData userData) {
        userData.setFileReader(getFileReader(userData.getFilePathRead()));
        userData.setFileWriter(getFileWriter(userData.getFilePathWrite()));
        userData.setReader(initializeReader(userData.getFileReader()));
        userData.setWriter(initializeWriter(userData.getFileWriter()));
    }

    private static BufferedReader initializeReader(FileReader fileReader) {
        return new BufferedReader(fileReader);
    }

    private static BufferedWriter initializeWriter(FileWriter fileWriter) {
        return new BufferedWriter(fileWriter);
    }

    private static FileReader getFileReader(String filePath) {
        try {
            return new FileReader(filePath);
        } catch (IOException e) {
            throw new FileNotFoundException(filePath);
        }
    }

    private static FileWriter getFileWriter(String filePath) {
        try {
            return new FileWriter(filePath);
        } catch (IOException e) {
            throw new FileNotFoundException(filePath);
        }
    }

}
