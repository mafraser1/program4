/*Author: Maxwell Fraser
Main class: User interface to use the spellchecker
 */
import java.util.Scanner;
import java.io.*;

public class Program4 {

    //creates a spell checker
    public static void main(String[] args) {
        SpellChecker spellCheck = new SpellChecker();
        String fileName;
        Scanner kb = new Scanner(System.in);
        System.out.println("Input the dictionary file name.");
        fileName = kb.nextLine();
        File inFile = new File(fileName);
        boolean isSet = spellCheck.setDictionary(inFile);
        //a file name is accepted from the user
        //file will be attempted to be opened
        //if there is an error, user will be prompted to enter another file name
        while (!isSet) {
            System.out.println("Dictionary file not found, try a different file.");
            fileName = kb.nextLine();
            inFile = new File(fileName);
            isSet = spellCheck.setDictionary(inFile);
        }
        System.out.println("What file needs to be spell checked?");
        int errors = check(spellCheck);
        //number of errors found given to user
        System.out.println(errors + " Spelling Errors Found.");

    }

    //accepts the spellChcker as a parameter and checks for errors
    //keeps track of how many errors are found
    public static int check(SpellChecker spellCheck) {

        int errors = 0;
        Scanner kb = new Scanner(System.in);
        String fileName = kb.nextLine();
        File checkFile = new File(fileName);
        boolean isFirst = true;
        PrintWriter outFile = null;
        //after user gives a second file to check it checks the file for errors
        try {
            Scanner compareFile = new Scanner(checkFile);
            while (compareFile.hasNext()) {
                String currentWord = compareFile.nextLine();
                if (!spellCheck.checkSpelling(currentWord.toUpperCase())) {
                    if (isFirst) {
                        System.out.println("Spelling Mistake found."
                                + "\nWhat file do you want resules output?");
                        outFile = new PrintWriter(kb.nextLine());
                        isFirst = false;

                    }
                    //outputs erroneous words to a file specified by the user
                    outFile.println(currentWord + "\n");
                    errors++;
                }
            }
            compareFile.close();

            //if a file not found error is caught, it recursively calls this method
        } catch (FileNotFoundException e) {
            System.out.println("File not found. Please try a different file name");
            errors = check(spellCheck);
            return errors;
        }
        outFile.close();
        return errors;
    }
}
