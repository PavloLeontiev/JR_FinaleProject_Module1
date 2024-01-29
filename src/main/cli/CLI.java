package main.cli;

import main.utils.FileHandler;

import java.io.IOException;
import java.util.Scanner;

public class CLI {
    private final static int COMMAND_ARGUMENT = 0;
    private final static int FILE_PATH_ARGUMENT = 1;
    private final static int KEY_ARGUMENT = 2;
    private static String OS;
    static Scanner scanner = new Scanner(System.in);


    public static String[] getInputArgument() {
        String[] args = new String[3];
        args[COMMAND_ARGUMENT] = getCommandArgument();
        args[FILE_PATH_ARGUMENT] = switch (getUserChoice().toUpperCase()) {
            case "YES" -> getNotepadFilePathArgument(args[COMMAND_ARGUMENT]);
            case "NO" -> getUserFilePathArgument();
            default -> throw new IllegalStateException("Unexpected value: " + getUserChoice().toUpperCase());
        };
        args[KEY_ARGUMENT] = getKeyArgument(args[COMMAND_ARGUMENT]);

        return args;
    }

    public static void openModifyFile(String filePathWrite) {
        try {
            OS = System.getProperty("os.name").toLowerCase();
            if (isWindows(OS)) {
                Runtime.getRuntime().exec("notepad " + filePathWrite);
            } else if (isMac(OS)) {
                Runtime.getRuntime().exec("open " + filePathWrite);
            }
            System.out.println("Path of modify file: " + filePathWrite);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private static String getCommandArgument() {
        System.out.println("""
                                
                                
                Welcome to the text encryption program!
                                
                !!! Pay attention: this program work just with ENGLISH and UKRAINIAN alphabets !!!
                                
                Choose the mode: ENCRYPT - to encrypt data;
                                 DECRYPT - to decrypt data;
                                 BRUTE_FORCE - to decrypt without key(just for CaesarCipher)
                                
                                
                """);
        return scanner.nextLine();
    }

    private static String getUserChoice() {
        System.out.println("""
                                
                                
                If you want to create a file now and enter text, enter YES
                or, if you already have a file with text, enter NO.
                     
                     
                """);
        String result = switch (scanner.nextLine().toUpperCase()) {
            case "YES" -> "YES";
            case "NO" -> "NO";
            default -> getUserChoice();
        };
        return result;
    }

    private static String getNotepadFilePathArgument(String mode) {
        String name = "renameMe.txt";
        String fileName = switch (mode.toUpperCase()) {
            case "ENCRYPT" -> name;
            case "DECRYPT", "BRUTE_FORCE" -> FileHandler.fileNameEncrypt(name);
            default -> throw new IllegalStateException("Unexpected value: " + mode.toUpperCase());
        };
        try {
            String currentWorkingDirectory = System.getProperty("user.dir");
            OS = System.getProperty("os.name").toLowerCase();
            if (isWindows(OS)) {
                currentWorkingDirectory += "\\" + fileName;
            } else if (isMac(OS)) {
                currentWorkingDirectory += "/" + fileName;
            }
            if (isWindows(OS)) {
                Runtime.getRuntime().exec("notepad " + currentWorkingDirectory);
            } else if (isMac(OS)) {
                Runtime.getRuntime().exec("open " + currentWorkingDirectory);
            }
            getSureSaveFile();
            return currentWorkingDirectory;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private static boolean isWindows(String OS) {
        return (OS.indexOf("win") >= 0);
    }

    private static boolean isMac(String OS) {
        return (OS.indexOf("mac") >= 0);
    }

    private static void getSureSaveFile() {
        System.out.println("""
                     
                                                
                Did you save file? Enter YES / NO
                    
                                
                """);
        switch (scanner.nextLine().toUpperCase()) {
            case "YES":
                break;
            case "NO":
                getSureSaveFile();
                break;
            default:
                System.out.println("Enter YES / NO !");
                getSureSaveFile();
        }
    }

    private static String getUserFilePathArgument() {
        System.out.println("""
                                
                                
                Please enter the path to the file:
                Example: C:\\Users\\sodr5\\IdeaProjects\\JR_FinaleProject_Module1\\src\\encryptMe.txt
                                
                !!! Pay attention !!!
                If there are spaces or special characters in the path to the jar file or to the text file.
                symbols: (* / \\ $ % & # @ ! ( ) { } [ ] , ; ' ” < > | ^ ~.)`,
                then enclose such a path in DOUBLE QUOTES
                                
                """);
        return scanner.nextLine();
    }

    private static String getKeyArgument(String mode) {
        switch (mode.toUpperCase()) {
            case "ENCRYPT", "DECRYPT":
                System.out.println("""
                                        
                                        
                Please enter your key:
                 № | Encryption method       | Possible key
                -------------------------------------------------------------------
                1) | CaesarCipher            | 0-∞
                2) | VigenereCipher          | Any word(without numbers and symbols)
                   |                         | the key must be in the same language as the content of the file
                                             
                """);
                break;
            case "BRUTE_FORCE":
                System.out.println("""
                                        
                                        
                Please enter your key:
                 № | Encryption method       | Possible key
                -------------------------------------------------------------------
                1) | Brute force for Caesar  | Caesar
                2) | Brute force for Vigenere| Vigenere(don`t work)
                3) | Brute force             |
                     default (CaeserCipher)  | Just press ENTER (without argument)
                             
                        """);
                break;
        }
        return scanner.nextLine();
    }

}
