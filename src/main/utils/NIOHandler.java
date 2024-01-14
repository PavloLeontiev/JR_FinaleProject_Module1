package main.utils;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

public class NIOHandler {

    public static void initializeFileChannelByteBuffer(UserData userData){
        userData.setFileChannelRead(getFileChannel(userData.getFilePathRead()));
        userData.setFileChannelWrite(getFileChannel(userData.getFilePathWrite()));
        userData.setByteBuffer(getByteBuffer());
    }
    private static FileChannel getFileChannel(String filePath){
        try(RandomAccessFile aFile = new RandomAccessFile(filePath, "rw");
            FileChannel channel = aFile.getChannel()){
            return channel;
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private static ByteBuffer getByteBuffer(){
        return ByteBuffer.allocate(1024);
    }
}
