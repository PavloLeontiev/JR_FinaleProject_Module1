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
    public static void main(String[] args) throws IOException {

        ////// PART 1 InputValidation ///////
        String[] arg = new String[3];
//        arg[0] = "ENCRYPT";
//        arg[1] = "C:\\Users\\sodr5\\IdeaProjects\\JR_FinaleProject_Module1\\src\\newFile.txt";
        arg[0] = "DECRYPT";
        arg[1] = "C:\\Users\\sodr5\\IdeaProjects\\JR_FinaleProject_Module1\\src\\newFile[ENCRYPTED].txt";
        arg[2] = "15";
        System.out.println("Please, type some arguments: ENCRYPT/DECRYPT/BRUTE_FORCE, file name and key.");
        Cipher user1 = new Cipher();
        InputValidation.validation(user1, arg);

        ////// PART 2 FileHandler and NIOHandler ///////

        FileHandler.fileValidation(user1);
        NIOHandler.initializeFileStreams(user1);
        AlphabetValidation.alphabetInitialize(user1);
        ////// PART 3 Cipher ///////
        user1.execute();




//        String filePathReader = "C:\\Users\\sodr5\\IdeaProjects\\JR_FinaleProject_Module1\\src\\newFile.txt";
//        FileReader fileReader = new FileReader(filePathReader);
//        BufferedReader reader = new BufferedReader(fileReader);
//
//        String filePathWriter = "C:\\Users\\sodr5\\IdeaProjects\\JR_FinaleProject_Module1\\src\\file.txt";
//        FileWriter fileWriter = new FileWriter(filePathWriter);
//        BufferedWriter writer = new BufferedWriter(fileWriter);
//
//        char[] array = new char[5];
//        int bytesRead = reader.read(array);
//        while(bytesRead != -1){
//            for(int i = 0; i < bytesRead; i++){
//                System.out.print(array[i]);
//            }
//            writer.write(array, 0, bytesRead);
//            writer.flush();
//            bytesRead = reader.read(array);
//        }
//        fileReader.close();
//        fileWriter.close();

    }
}