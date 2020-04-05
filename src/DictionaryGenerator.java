import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class DictionaryGenerator {
    public static void main(String[] args) {

        boolean valid = true;
        Scanner keyboard = new Scanner(System.in);
        Scanner scanner = null;
        PrintWriter pw = null;

        ArrayList<String> words_split = new ArrayList<>();
        ArrayList<String> list = new ArrayList<>();
        String[] numbers = {"1", "2", "3", "4", "5", "6", "7", "8", "9", "0"};

        // User message
        System.out.println("Please input the name of the file: ");
        String input_file = keyboard.next();

        try {
            scanner = new Scanner(new FileInputStream("src/" + input_file));


            while (scanner.hasNext()) {
                words_split.add(scanner.next());
            }

            for (String word : words_split) {
                valid = true;
                // if word is single character
                if (word.length() == 1) {
                    if (!(word.equals("a") || word.equals("A") || word.equals("i") || word.equals("I"))) {
                        valid = false;
                    }
                }

                // removing apostrophe
                if (word.contains("\'")) {
                    word = word.substring(0, word.indexOf("'"));
                }

                // looking for "?", ":", ",", ";", "!", "."
                if (word.endsWith("?") || word.endsWith(":") || word.endsWith(",") || word.endsWith(";") || word.endsWith("!") || word.endsWith(".")) {
                    word = word.substring(0, word.length() - 1);
                }
                // looking for any numbers
                for (String number : numbers) {
                    if (word.contains(number)) {
                        valid = false;
                        break;
                    }
                }

                for (String item : list) {
                    if (item.equals(word.toUpperCase())) {
                        valid = false;
                        break;
                    }
                }

                if (valid) {
                    list.add(word.toUpperCase());
                }
            }

            //sort the arraylist alphabetically
            list.sort(String.CASE_INSENSITIVE_ORDER);
            int entries = list.size();
            String[] letters = {"A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L",
            "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z"};
            boolean found;
            boolean done = false;
            int i = 0; // list Arralist increment
            int l = 0; // letters array increment

            while (!done) {
                do {
                    found = false;
                    // print out title for each starting letter
                    if (list.get(i).startsWith(letters[l])) {
                        System.out.println("\n" + letters[l] + "\n=");
                        found = true;
                    } else {
                        l++; // moves onto next letter
                    }
                }
                while (!found);

                // while word starts with that letter, print it
                while (list.get(i).startsWith(letters[l])) {
                    System.out.println(list.get(i));
                    if (i < entries - 1) {
                        i++; // moves to next word
                    } else {
                        done = true;
                        break; // done list
                    }
                }
                l++; // moves onto next starting letter
            }

            System.out.println("\nThe document produced this sub-dictionary, which included " + entries + " entries.");
            scanner.close();
        } catch (FileNotFoundException e) {
            System.out.println(e);
        }


        try {
            pw = new PrintWriter(new FileOutputStream("SubDictionary.txt"));

            // printing every word in the Arraylist
            for (String input : list) {
                pw.println(input);
            }

            pw.close();
        } catch (FileNotFoundException e) {
            System.out.println(e);
        }


        // allow for blank input file??

        // mc exception
        keyboard.close();
    }
}
