
import java.util.Scanner;
import java.io.*;

public class SpellChecker {

    private DoublyLinkedBag<String> correctWords;
    private int size;

    public SpellChecker() {
        correctWords = new DoublyLinkedBag();
        size = 0;
    }

    public boolean setDictionary(File correctWordFile) {
        try{
        Scanner inFile = new Scanner(correctWordFile);
        while(inFile.hasNext()){
            correctWords.add(inFile.nextLine());
        }
        }
        catch(FileNotFoundException e){
            return false;
        }

        return true;
    }

    public boolean checkSpelling(String word) {
        return correctWords.contains(word);
    }

    public int count() {
        return size;
    }
}
