package main.utils;

import main.utils.modes.AlgorithmMode;
import main.utils.modes.CipherMode;

public class UserData {
    private String filePath;
    private CipherMode cipherMode;
    private AlgorithmMode algorithmMode;
    private int key;

    public String getFilePath() {
        return filePath;
    }

    public void setFilePath(String filePath) {
        this.filePath = filePath;
    }


    public CipherMode getCipherMode() {
        return cipherMode;
    }

    public void setCipherMode(CipherMode cipherMode) {
        this.cipherMode = cipherMode;
    }

    public AlgorithmMode getAlgorithmMode() {
        return algorithmMode;
    }

    public void setAlgorithmMode(AlgorithmMode algorithmMode) {
        this.algorithmMode = algorithmMode;
    }

    public int getKey() {
        return key;
    }

    public void setKey(int key) {
        this.key = key;
    }
}
