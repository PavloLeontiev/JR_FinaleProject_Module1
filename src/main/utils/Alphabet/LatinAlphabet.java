package main.utils.Alphabet;

import java.util.Arrays;
import java.util.List;

public class LatinAlphabet {
        private static LatinAlphabet instance = null;
        private int numberOfLettersAlphabet = 26;
        private Character[] alphabet = {
                'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M',
                'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z',
                'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm',
                'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z'
        };
        private List<Character> alphabetList = Arrays.asList(alphabet);

        private LatinAlphabet(){
            System.out.println("SingletonEN is created!");
        }

        public static LatinAlphabet getInstance(){
            if(instance == null){
                instance = new LatinAlphabet();
            }
            return instance;
        }

        public Character getLetter(int index){
            return alphabetList.get(index);
        }

        public int getNumberOfLettersAlphabet(){
            return numberOfLettersAlphabet;
        }

        public boolean isAlphabet(char letter){
            return alphabetList.contains(letter);
        }

        public int getIndex(char letter){
            return alphabetList.indexOf(letter);
        }
}
