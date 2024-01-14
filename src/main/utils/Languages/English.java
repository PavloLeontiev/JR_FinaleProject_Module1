package main.utils.Languages;

import java.util.Arrays;
import java.util.List;

public class English {
        private static English instance = null;
        private int numberOfLettersAlphabet = 26;
        private Character[] alphabet = {
                'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M',
                'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z',
                'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm',
                'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z'
        };
        private List<Character> alphabetList = Arrays.asList(alphabet);

        private English(){
            System.out.println("SingletonEN is created!");
        }

        public static English getInstance(){
            if(instance == null){
                instance = new English();
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
