package main.alphabet;

import java.util.HashMap;

public class EnglishAlphabet extends Alphabet{

    private HashMap<Character, Character> alphabetMap = new HashMap<>();

    public void initializeAlphabet(int key){
        System.out.println(91%90);
        int modifyChar = 0;
        int firstByteAlphabet = 65;
        int lastByteAlphabet = 90;
        int consistLetters = 26;
        for (int i = 1; i <= consistLetters; i++) {
            modifyChar = firstByteAlphabet + key;
            alphabetMap.put((char)firstByteAlphabet, (char)(modifyChar > lastByteAlphabet ? modifyChar % lastByteAlphabet + 64 : modifyChar));
            firstByteAlphabet++;
        }

        // Виводить зміст HashMap
        System.out.println("Алфавит в структуре данных HashMap:");
        for (char ch : alphabetMap.keySet()) {
            char value = alphabetMap.get(ch);
            System.out.println(ch + ": " + value);
        }
    }

    public HashMap<Character, Character> getAlphabet(){
        return alphabetMap;
    }
}
