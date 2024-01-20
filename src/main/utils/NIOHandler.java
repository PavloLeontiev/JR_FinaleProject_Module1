package main.utils;

import main.encryption.UserData;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

public class NIOHandler {

    public static void initializeFileChannel(UserData userData){
        userData.setFileChannelRead(getFileChannel(userData.getFilePathRead()));
        userData.setFileChannelWrite(getFileChannel(userData.getFilePathWrite()));
    }

    public static void initializeByteBuffer(UserData userData){
        userData.setByteBuffer(getByteBuffer());
    }

    private static FileChannel getFileChannel(String filePath){
        try{
            RandomAccessFile aFile = new RandomAccessFile(filePath, "rws");
            FileChannel channel = aFile.getChannel();
            return channel;
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    private static ByteBuffer getByteBuffer(){
        return ByteBuffer.allocate(128);
    }
}
