package main.encryption;

import main.alphabet.Alphabet;
import main.encryption.cipher_algorithm.CipherAlgorithm;
import main.modes.CipherMode;

import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

public class UserData {
    protected String filePathRead;
    protected String filePathWrite;
    protected FileChannel fileChannelRead;
    protected FileChannel fileChannelWrite;
    protected ByteBuffer byteBuffer;
    protected CipherMode cipherMode;
    protected CipherAlgorithm cipherAlgorithm;
    protected Alphabet alphabet;
    protected String key;

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

    public void setByteBuffer(ByteBuffer byteBufferRead) {
        this.byteBuffer = byteBufferRead;
    }

    public CipherMode getCipherMode() {
        return cipherMode;
    }

    public void setCipherMode(CipherMode cipherMode) {
        this.cipherMode = cipherMode;
    }

    public CipherAlgorithm getCipherAlgorithm() {
        return cipherAlgorithm;
    }

    public void setCipherAlgorithm(CipherAlgorithm cipherAlgorithm) {
        this.cipherAlgorithm = cipherAlgorithm;
    }

    public Alphabet getAlphabet() {
        return alphabet;
    }

    public void setAlphabet(Alphabet alphabet) {
        this.alphabet = alphabet;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

}
