package main.utils;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.util.Random;

public class NIOHandler {
    public static FileChannel getAccessFileChannel(UserData userData){
        try(RandomAccessFile aFile = new RandomAccessFile(userData.getFilePath(), "r");
            FileChannel channel = aFile.getChannel()){
            return channel;
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

}
