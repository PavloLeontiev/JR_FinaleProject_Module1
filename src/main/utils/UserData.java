package main.utils;

import main.encryption.algorithms.Algorithm;
import main.utils.modes.CipherMode;

import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

public class UserData {
    private String filePathRead;
    private String filePathWrite;
    private FileChannel fileChannelRead;
    private FileChannel fileChannelWrite;
    private ByteBuffer byteBuffer;
    private CipherMode cipherMode;
    private Algorithm algorithm;
    private int key;
    private int fileSize;

    public String getFilePathRead() {
        return filePathRead;
    }

    public void setFilePathRead(String filePathRead) {
        this.filePathRead = filePathRead;
    }

    public String getFilePathWrite() {
        return filePathWrite;
    }

    public void setFilePathWrite(String filePathWrite) {
        this.filePathWrite = filePathWrite;
    }

    public FileChannel getFileChannelRead() {
        return fileChannelRead;
    }

    public void setFileChannelRead(FileChannel fileChannelRead) {
        this.fileChannelRead = fileChannelRead;
    }

    public FileChannel getFileChannelWrite() {
        return fileChannelWrite;
    }

    public void setFileChannelWrite(FileChannel fileChannelWrite) {
        this.fileChannelWrite = fileChannelWrite;
    }

    public ByteBuffer getByteBuffer() {
        return byteBuffer;
    }

    public void setByteBuffer(ByteBuffer byteBuffer) {
        this.byteBuffer = byteBuffer;
    }

    public CipherMode getCipherMode() {
        return cipherMode;
    }

    public void setCipherMode(CipherMode cipherMode) {
        this.cipherMode = cipherMode;
    }

    public Algorithm getAlgorithm() {
        return algorithm;
    }

    public void setAlgorithm(Algorithm algorithm) {
        this.algorithm = algorithm;
    }

    public int getKey() {
        return key;
    }

    public void setKey(int key) {
        this.key = key;
    }

    public int getFileSize() {
        return fileSize;
    }

    public void setFileSize(int fileSize) {
        this.fileSize = fileSize;
    }
}
