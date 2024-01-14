package main.encryption;

import main.encryption.algorithms.CaesarCipher;
import main.utils.NIOHandler;
import main.utils.UserData;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

public class Encryptor {
    protected static void execute(UserData userData){
        switch (userData.getAlgorithmMode()){
            // case CAESARCIPHER : CaesarCipher.getInstance();
        }
    }
}
