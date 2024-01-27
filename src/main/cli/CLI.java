package main.cli;

import java.util.Scanner;

public class CLI {
    static Scanner scanner = new Scanner(System.in);

    public static String[] getInputArgument() {
        String[] args = new String[3];
        System.out.println("""
                Welcome to the text encryption program!
                Choose the mode: ENCRYPT - to encrypt data;
                                 DECRYPT - to decrypt data;
                                 BRUTE-FORCE - to decrypt without key.
                """);
        args[0] = scanner.nextLine();
        System.out.println("""
                Please enter the path to the file:
                Example: C:\\Users\\sodr5\\IdeaProjects\\JR_FinaleProject_Module1\\src\\encryptMe.txt
                                
                !!! Pay attention !!!
                If there are spaces or special characters in the path to the jar file or to the text file. 
                symbols: (* / \\ $ % & # @ ! ( ) { } [ ] , ; ' ” < > | ^ ~.)`,
                then enclose such a path in DOUBLE QUOTES
                """);
        args[1] = scanner.nextLine();
        System.out.println("""
                Please enter your key:
                Possible options: 
                № | Encryption method       | Possible key
                1 | CaesarCipher            | 0-∞
                2 | VigenereCipher          | Any word(without numbers and symbols)
                3 | Brute force for Caesar  | Caesar
                4 | Brute force for Vigenere| Vigenere
                5 | default (CaeserCipher)  | null(without argument)
                """);
        args[2] = scanner.nextLine();
        return args;
    }
}
