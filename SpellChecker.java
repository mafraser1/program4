/*
Author: Maxwell Fraser
The spellchecker class, makes a dictionary of words and checks for any words
not in the dictionary.
 */
import java.util.Scanner;
import java.io.*;

public class SpellChecker {

    private DoublyLinkedBag<String> correctWords;
    private int size;

    public SpellChecker() {
        correctWords = new DoublyLinkedBag();
        size = 0;
    }

    //uses the passed file as a scanner, and creates a doubly linked bag uses it's data
    public boolean setDictionary(File correctWordFile) {
        try {
            Scanner inFile = new Scanner(correctWordFile);
            while (inFile.hasNext()) {
                String input = inFile.nextLine().toUpperCase();
                correctWords.add(input);

            }
            inFile.close();
        } catch (FileNotFoundException e) {
            return false;
        }
        return true;
    }

    //checks to see if a word is contained in the user created dictionary
    public boolean checkSpelling(String word) {
        return correctWords.contains(word);
    }

    //returns the size of the dictionary
    public int count() {
        return size;
    }
}
