import main.alphabet.UkrainianAlphabet;
import main.encryption.Cipher;
import main.utils.AlphabetValidation;
import main.utils.FileHandler;
import main.utils.InputValidation;
import main.utils.NIOHandler;

import java.io.*;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.channels.FileChannel;
import java.nio.charset.StandardCharsets;
import java.util.LinkedHashMap;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {
        System.out.println("Please, type some arguments: ENCRYPT/DECRYPT/BRUTE_FORCE, file path and key.");
        String[] arg = new String[3];
//        arg[0] = "ENCRYPT";
//        arg[1] = "C:\\Users\\sodr5\\IdeaProjects\\JR_FinaleProject_Module1\\src\\newFile.txt";
        arg[0] = "DECRYPT";
        arg[1] = "C:\\Users\\sodr5\\IdeaProjects\\JR_FinaleProject_Module1\\src\\newFile[ENCRYPTED].txt";
        arg[2] = "15";
        Cipher cipher = new Cipher();
        InputValidation.validation(cipher, arg);
        FileHandler.fileValidation(cipher);
        NIOHandler.initializeFileStreams(cipher);
        AlphabetValidation.alphabetInitialize(cipher);
        cipher.execute();

    }
}