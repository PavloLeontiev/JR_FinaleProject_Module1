import main.utils.FileHandler;
import main.utils.InputValidation;
import main.utils.UserData;

import java.io.File;
import java.io.IOException;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {

        ////// PART 1 InputValidation ///////
        String[] arg = new String[3];
        arg[0] = "DECRYPT";
        arg[1] = "C:\\Users\\sodr5\\IdeaProjects\\JR_FinaleProject_Module1\\src\\newFile.txt";
        arg[2] = "3";
        System.out.println("Please, type some arguments: ENCRYPT/DECRYPT/BRUTE_FORCE, file name and key.");
        UserData user1 = new UserData();
        InputValidation.getInstance().validation(user1, arg);

        ////// PART 2 FileHandler ///////

        FileHandler.fileValidation(user1);
    }
}