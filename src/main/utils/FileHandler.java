package main.utils;

import org.w3c.dom.ls.LSOutput;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.file.FileAlreadyExistsException;

public class FileHandler {

    public static void fileValidation(UserData userData){
        if(!checkFileExisting(userData.getFilePathRead())) try {
            throw new FileNotFoundException();
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }

        initializeFileNameWrite(userData);

        if(checkFileExisting(userData.getFilePathWrite())) try {
            throw new FileAlreadyExistsException(userData.getFilePathWrite());
        } catch (FileAlreadyExistsException e) {
            throw new RuntimeException(e);
        }

        createFile(userData);
    }

    private static boolean checkFileExisting(String filePath){
        File file = new File(filePath);
        return file.exists();
    }
    private static void checkFileContent2(UserData userData) {
        try(RandomAccessFile aFile = new RandomAccessFile(userData.getFilePathRead(), "rw");
        FileChannel inChannel = aFile.getChannel()) {
            ByteBuffer buf = ByteBuffer.allocate(128);
            int bytesRead = inChannel.read(buf);
            int cyrillicAlphabet = 0;
            int latinAlphabet = 0;
            int currentByte = 0;
            while (bytesRead != -1) {
                buf.flip();
                while (buf.hasRemaining()) {
                    currentByte = buf.get();
                    if (currentByte >= 65 && currentByte <= 122) {
                        latinAlphabet++;
                    } else if (currentByte < 0) {
                        cyrillicAlphabet++;
                    } else {
                        System.out.println("Another");
                    }
                }
                buf.clear(); //make buffer ready for writing
                bytesRead = inChannel.read(buf);
                System.out.println(latinAlphabet);
                System.out.println(cyrillicAlphabet);
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private static void createFile(UserData userData) {
        File file = new File(userData.getFilePathWrite());
        try {
            file.createNewFile();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private static void initializeFileNameWrite(UserData userData){
        String mode = switch (userData.getCipherMode()){
            case ENCRYPT -> mode = "[ENCRYPTED]";
            case DECRYPT -> mode = "[DECRYPTED]";
            case BRUTE_FORCE -> null;
        };
        String fileRead = userData.getFilePathRead();
        int index = fileRead.lastIndexOf('.');
        String fileWrite = fileRead.substring(0, index) + mode + fileRead.substring(index);
        userData.setFilePathWrite(fileWrite);
    }
}
