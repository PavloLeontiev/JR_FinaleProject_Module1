package main.utils;

import main.encryption.Algorythm;

import java.io.File;
import java.nio.file.Path;

public class UserData {
    private String filePath;
    private Algorythm algorythm;
    private Mode mode;
    private int key;

    public String getFilePath() {
        return filePath;
    }

    public void setFilePath(String filePath) {
        this.filePath = filePath;
    }

    public Algorythm getAlgorythm() {
        return algorythm;
    }

    public void setAlgorythm(Algorythm algorythm) {
        this.algorythm = algorythm;
    }

    public Mode getMode() {
        return mode;
    }

    public void setMode(Mode mode) {
        this.mode = mode;
    }

    public int getKey() {
        return key;
    }

    public void setKey(int key) {
        this.key = key;
    }
}
