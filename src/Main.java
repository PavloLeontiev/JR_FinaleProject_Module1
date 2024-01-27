import main.encryption.Cipher;
import main.utils.AlphabetValidation;
import main.utils.FileHandler;
import main.utils.InputValidation;
import main.utils.NIOHandler;

public class Main {
    public static void main(String[] args) {
        System.out.println("Please, type some arguments: ENCRYPT/DECRYPT/BRUTE_FORCE, file path and key.");
        String[] arg = new String[3];
//        arg[0] = "ENCRYPT";
//        arg[1] = "C:\\Users\\sodr5\\IdeaProjects\\JR_FinaleProject_Module1\\src\\newFile.txt";
//        arg[2] = "3";
//        arg[0] = "DECRYPT";
//        arg[1] = "C:\\Users\\sodr5\\IdeaProjects\\JR_FinaleProject_Module1\\src\\newFile[ENCRYPTED].txt";
//        arg[2] = "3";
        arg[0] = "BRUTE_FORCE";
        arg[1] = "C:\\Users\\sodr5\\IdeaProjects\\JR_FinaleProject_Module1\\src\\newFile[ENCRYPTED].txt";
        arg[2] = "CaesarCipher";
        Cipher cipher = new Cipher();
        InputValidation.validation(cipher, arg);
        FileHandler.fileValidation(cipher);
        NIOHandler.initializeFileStreams(cipher);
        AlphabetValidation.alphabetInitialize(cipher);
        cipher.execute();

    }
}