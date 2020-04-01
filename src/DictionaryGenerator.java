import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class DictionaryGenerator {
    public static void main(String[] args) {

        boolean valid = true;
        Scanner keyboard = new Scanner(System.in);
        Scanner scanner = null;
        ArrayList<String> words_split = new ArrayList<>();
        ArrayList<String> list = new ArrayList<>();
        String[] numbers = {"1", "2", "3", "4", "5", "6", "7", "8", "9", "0"};

        System.out.println("Please input the name of the file: ");
        String input_file = keyboard.next();

        try {
            scanner = new Scanner(new FileInputStream("src/" + input_file));


            while (scanner.hasNextLine()) {
                words_split.add(scanner.next());
            }

            for (String word : words_split) {

                // if word is single character
                if (word.length() == 1) {
                    if (!(word.equals("a") || word.equals("A") || word.equals("i") || word.equals("I"))) {
                        valid = false;
                    }
                }

                // looking for "?", ":", ",", ";", "!", "."
                if (word.endsWith("?") || word.endsWith(":") || word.endsWith(",") || word.endsWith(";") || word.endsWith("!") || word.endsWith(".")) {
                    word = word.substring(0, word.length() - 1);
                }
                // looking for any numbers
                for (String number : numbers) {
                    if (word.contains(number)) {
                        word = word.substring(0, word.indexOf(number)) + word.substring(word.indexOf(number) + 1);
                    }

                }
                if (valid) {
                    list.add(word);
                    System.out.println(list);
                }
            }


            scanner.close();
        } catch (FileNotFoundException e) {
            System.out.println(e);
        }


        // allow for blank input file??
        // split by words
        // make sure no characters
        // exclude single characters
        // mc exception
        keyboard.close();
    }
}
