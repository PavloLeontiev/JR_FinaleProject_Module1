package main.utils;

import main.encryption.CipherData;
import main.exception.FileNotFoundException;

import java.io.*;

public class NIOHandler {

    public static void initializeFileStreams(CipherData cipherData) {
        cipherData.setFileReader(getFileReader(cipherData.getFilePathRead()));
        cipherData.setFileWriter(getFileWriter(cipherData.getFilePathWrite()));
        cipherData.setBufferCapacity(initializeBufferCapacity());
        cipherData.setReader(initializeReader(cipherData.getFileReader(), cipherData.getBufferCapacity()));
        cipherData.setWriter(initializeWriter(cipherData.getFileWriter(), cipherData.getBufferCapacity()));
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

    private static int initializeBufferCapacity() {
        int bufferCapacity = 1024;
        return bufferCapacity;
    }

    private static BufferedReader initializeReader(FileReader fileReader, int bufferCapacity) {
        return new BufferedReader(fileReader, bufferCapacity);
    }

    private static BufferedWriter initializeWriter(FileWriter fileWriter, int bufferCapacity) {
        return new BufferedWriter(fileWriter, bufferCapacity);
    }

}
