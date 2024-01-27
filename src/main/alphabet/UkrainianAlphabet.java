package main.alphabet;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashMap;

public class UkrainianAlphabet extends Alphabet {
    public UkrainianAlphabet() {
        initializeAlphabet(0);
    }
    private final int LETTERS_IN_ALPHABET = 33;
    private final char[] UPPERCASE_ENGLISH_ALPHABET_ARRAY = {
            'А', 'Б', 'В', 'Г', 'Ґ', 'Д', 'Е', 'Є', 'Ж', 'З', 'И', 'І', 'Ї', 'Й',
            'К', 'Л', 'М', 'Н', 'О', 'П', 'Р', 'С', 'Т', 'У', 'Ф', 'Х', 'Ц', 'Ч',
            'Ш', 'Щ', 'Ь', 'Ю', 'Я'
    };

    private final char[] LOWERCASE_ENGLISH_ALPHABET_ARRAY = {
            'а', 'б', 'в', 'г', 'ґ', 'д', 'е', 'є', 'ж', 'з', 'и', 'і', 'ї', 'й',
            'к', 'л', 'м', 'н', 'о', 'п', 'р', 'с', 'т', 'у', 'ф', 'х', 'ц', 'ч',
            'ш', 'щ', 'ь', 'ю', 'я'
    };
    private final ArrayList<String> FREQUENTLY_USED_WORDS = new ArrayList<>(Arrays.asList(
            "не", "на", "що", "вони", "ви", "ми", "він",
            "так", "але", "все", "від", "коли", "як", "вже", "до",
            "від", "щоб", "за", "то", "якщо", "його", "також",
            "тут", "або", "по", "ні", "зі", "був", "це", "там",
            "дуже", "тільки", "мені", "вона", "привіт", "ти", "це",
            "де", "чому", "так", "може", "завжди", "ніколи",
            "добре", "погано", "багато", "мало", "великий", "малий",
            "дуже", "тільки", "спасибі", "будь ласка", "просто",
            "зрозуміти", "робити", "хочу", "потрібно", "можливо",
            "сьогодні", "завтра", "вчора", "ранок", "день", "вечір",
            "ніч", "робота", "навчання", "життя", "любити", "ненавидіти",
            "сім'я", "друзі", "гроші", "час", "інтересно", "красиво",
            "щасливий", "сумний", "здоров'я"
    ));
    private final LinkedHashMap<Character, Character> UPPERCASE_ALPHABET_LETTERS = new LinkedHashMap<>();
    private final LinkedHashMap<Character, Character> LOWERCASE_ALPHABET_LETTERS = new LinkedHashMap<>();

    public LinkedHashMap<Character, Character> getUPPERCASE_ALPHABET_LETTERS() {
        return UPPERCASE_ALPHABET_LETTERS;
    }

    public LinkedHashMap<Character, Character> getLOWERCASE_ALPHABET_LETTERS() {
        return LOWERCASE_ALPHABET_LETTERS;
    }

    public void initializeAlphabet(int key) {
        initializeAlphabetCapitalLetters(key);
        initializeAlphabetSmallLetters(key);
    }

    private void initializeAlphabetCapitalLetters(int key) {
        char[] alphabet = UPPERCASE_ENGLISH_ALPHABET_ARRAY;
        int modifyIndex = 0;
        for (int i = 0; i < LETTERS_IN_ALPHABET; i++) {
            modifyIndex = i + key;
            UPPERCASE_ALPHABET_LETTERS.put(alphabet[i], modifyIndex >= LETTERS_IN_ALPHABET ? alphabet[modifyIndex % LETTERS_IN_ALPHABET] : alphabet[modifyIndex]);
        }
    }

    private void initializeAlphabetSmallLetters(int key) {
        char[] alphabet = LOWERCASE_ENGLISH_ALPHABET_ARRAY;
        int modifyIndex = 0;
        for (int i = 0; i < LETTERS_IN_ALPHABET; i++) {
            modifyIndex = i + key;
            LOWERCASE_ALPHABET_LETTERS.put(alphabet[i], modifyIndex >= LETTERS_IN_ALPHABET ? alphabet[modifyIndex % LETTERS_IN_ALPHABET] : alphabet[modifyIndex]);
        }
    }

    public boolean isLetter(char ch) {
        if (UPPERCASE_ALPHABET_LETTERS.containsKey(ch)) return true;
        else if (LOWERCASE_ALPHABET_LETTERS.containsKey(ch)) return true;
        else return false;
    }

    public boolean isUpperCase(char ch) {
        return UPPERCASE_ALPHABET_LETTERS.containsKey(ch);
    }

    public boolean isLowerCase(char ch) {
        return LOWERCASE_ALPHABET_LETTERS.containsKey(ch);
    }

    public int getLETTERS_IN_ALPHABET() {
        return LETTERS_IN_ALPHABET;
    }

    public ArrayList<String> getFREQUENTLY_USED_WORDS() {
        return FREQUENTLY_USED_WORDS;
    }

}
