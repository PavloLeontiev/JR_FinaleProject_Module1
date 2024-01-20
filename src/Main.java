import main.encryption.Cipher;
import main.utils.FileHandler;
import main.utils.InputValidation;
import main.utils.NIOHandler;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {

        ////// PART 1 InputValidation ///////
        String[] arg = new String[3];
        arg[0] = "DECRYPT";
        arg[1] = "C:\\Users\\sodr5\\IdeaProjects\\JR_FinaleProject_Module1\\src\\newFile[ENCRYPTED].txt";
        arg[2] = "1";
        System.out.println("Please, type some arguments: ENCRYPT/DECRYPT/BRUTE_FORCE, file name and key.");
        Cipher user1 = new Cipher();
        InputValidation.validation(user1, arg);

        ////// PART 2 FileHandler and NIOHandler ///////

        FileHandler.fileValidation(user1);
        NIOHandler.initializeFileChannel(user1);
        NIOHandler.initializeByteBuffer(user1);

        ////// PART 3 Cipher ///////
        user1.execute();

    }
}