package main.alphabet;

import java.util.HashMap;
import java.util.LinkedHashMap;

public class UkrainianAlphabet extends Alphabet{
    private char[] uppercaseUkrainianAlphabetArray = {
            'А', 'Б', 'В', 'Г', 'Ґ', 'Д', 'Е', 'Є', 'Ж', 'З', 'И', 'І', 'Ї', 'Й',
            'К', 'Л', 'М', 'Н', 'О', 'П', 'Р', 'С', 'Т', 'У', 'Ф', 'Х', 'Ц', 'Ч',
            'Ш', 'Щ', 'Ь', 'Ю', 'Я'
    };

    private char[] lowercaseUkrainianAlphabetArray = {
            'а', 'б', 'в', 'г', 'ґ', 'д', 'е', 'є', 'ж', 'з', 'и', 'і', 'ї', 'й',
            'к', 'л', 'м', 'н', 'о', 'п', 'р', 'с', 'т', 'у', 'ф', 'х', 'ц', 'ч',
            'ш', 'щ', 'ь', 'ю', 'я'
    };
    private final LinkedHashMap<Character, Character> alphabetCapitalLetters = new LinkedHashMap<>();
    private final LinkedHashMap<Character, Character> alphabetSmallLetters = new LinkedHashMap<>();
    public HashMap<Character, Character> getAlphabetCapitalLetters(){
        return alphabetCapitalLetters;
    }
    public HashMap<Character, Character> getAlphabetSmallLetters(){
        return alphabetCapitalLetters;
    }
    public void initializeAlphabet(int key){
        initializeAlphabetCapitalLetters(key);
        initializeAlphabetSmallLetters(key);
    }

    private void initializeAlphabetCapitalLetters(int key){
        char[] alphabet = uppercaseUkrainianAlphabetArray;
        int modifyIndex = 0;
        for (int i = 0; i < 26; i++) {
            modifyIndex = i + key;
            alphabetCapitalLetters.put(alphabet[i], modifyIndex >= 26 ? alphabet[modifyIndex % 26] : alphabet[modifyIndex]);
        }
        System.out.println("Алфавіт української мови в структурі даних HashMap:");
        for (char k : alphabetCapitalLetters.keySet()) {
            char value = alphabetCapitalLetters.get(k);
            System.out.println(k + ": " + value);
        }
    }
    private void initializeAlphabetSmallLetters(int key){
        char[] alphabet = lowercaseUkrainianAlphabetArray;
        int modifyIndex = 0;
        for (int i = 0; i < 26; i++) {
            modifyIndex = i + key;
            alphabetSmallLetters.put(alphabet[i], modifyIndex >= 26 ? alphabet[modifyIndex % 26] : alphabet[modifyIndex]);
        }
        System.out.println("Алфавіт української мови в структурі даних HashMap:");
        for (char k : alphabetSmallLetters.keySet()) {
            char value = alphabetSmallLetters.get(k);
            System.out.println(k + ": " + value);
        }
    }
}
