package main.encryption;

import main.alphabet.Alphabet;
import main.encryption.cipher_algorithm.CipherAlgorithm;
import main.modes.CipherMode;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

public class UserData {
    protected String filePathRead;
    protected String filePathWrite;
    protected FileReader fileReader;
    protected FileWriter fileWriter;
    protected BufferedReader reader;
    protected BufferedWriter writer;
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

    public FileReader getFileReader() {
        return fileReader;
    }

    public void setFileReader(FileReader fileReader) {
        this.fileReader = fileReader;
    }

    public FileWriter getFileWriter() {
        return fileWriter;
    }

    public void setFileWriter(FileWriter fileWriter) {
        this.fileWriter = fileWriter;
    }

    public BufferedReader getReader() {
        return reader;
    }

    public void setReader(BufferedReader reader) {
        this.reader = reader;
    }

    public BufferedWriter getWriter() {
        return writer;
    }

    public void setWriter(BufferedWriter writer) {
        this.writer = writer;
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
