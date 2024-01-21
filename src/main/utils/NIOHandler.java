package main.utils;

import main.encryption.UserData;

import java.io.*;
public class NIOHandler {

    public static void initializeFileStreams(UserData userData){
        userData.setFileReader(getFileReader(userData.getFilePathRead()));
        userData.setFileWriter(getFileWriter(userData.getFilePathWrite()));
        userData.setReader(initializeReader(userData.getFileReader()));
        userData.setWriter(initializeWriter(userData.getFileWriter()));
    }

    private static BufferedReader initializeReader(FileReader fileReader){
        return new BufferedReader(fileReader);
    }
    private static BufferedWriter initializeWriter(FileWriter fileWriter){
        return new BufferedWriter(fileWriter);
    }
    private static FileReader getFileReader(String filePath){
        try{
            return new FileReader(filePath);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    private static FileWriter getFileWriter(String filePath){
        try{
            return new FileWriter(filePath);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
