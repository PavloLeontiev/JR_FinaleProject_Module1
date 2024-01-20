package main.utils;


import main.encryption.UserData;
import main.exception.FileAlreadyExistsException;
import main.exception.FileNotFoundException;

import java.io.File;
import java.io.IOException;

public class FileHandler {

    public static void fileValidation(UserData userData){
        checkFileExisting(userData.getFilePathRead());
        initializeFileNameWrite(userData);
        createFile(userData.getFilePathWrite());
    }

    private static void checkFileExisting(String filePath){
        File file = new File(filePath);
        if (!file.exists())
            throw new FileNotFoundException(filePath);
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


    private static void createFile(String filePath) {
        File file = new File(filePath);
        try {
            if(!file.createNewFile())
                throw new FileAlreadyExistsException(filePath);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    //    private static void checkFileContent2(UserData userData) {
//        try(RandomAccessFile aFile = new RandomAccessFile(userData.getFilePathRead(), "rw");
//        FileChannel inChannel = aFile.getChannel()) {
//            ByteBuffer buf = ByteBuffer.allocate(128);
//            int bytesRead = inChannel.read(buf);
//            int cyrillicAlphabet = 0;
//            int latinAlphabet = 0;
//            int currentByte = 0;
//            while (bytesRead != -1) {
//                buf.flip();
//                while (buf.hasRemaining()) {
//                    currentByte = buf.get();
//                    if (currentByte >= 65 && currentByte <= 122) {
//                        latinAlphabet++;
//                    } else if (currentByte < 0) {
//                        cyrillicAlphabet++;
//                    } else {
//                        System.out.println("Another");
//                    }
//                }
//                buf.clear(); //make buffer ready for writing
//                bytesRead = inChannel.read(buf);
//                System.out.println(latinAlphabet);
//                System.out.println(cyrillicAlphabet);
//            }
//        } catch (FileNotFoundException e) {
//            throw new RuntimeException(e);
//        } catch (IOException e) {
//            throw new RuntimeException(e);
//        }
//    }
}
