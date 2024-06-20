import java.util.*;
import java.io.*;

public class wordCounter {

    // Set of common stop words to ignore
    private static final Set<String> STOP_WORDS = new HashSet<>(Arrays.asList(
            "a", "an", "and", "the", "to", "of", "in", "is", "it", "that", "with", "as", "for", "on", "was", "at", "by", "which"));

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String text = "";

        // Prompt user to enter text or file path
        System.out.println("Enter text or the path to a text file:");
        String input = scanner.nextLine();

        // Check if input is a file path
        File file = new File(input);
        if (file.exists() && file.isFile()) {
            text = readFile(file);
        } else {
            text = input;
        }

        // Split the text into words and count them
        Map<String, Integer> wordCount = countWords(text);

        // Display the total word count
        System.out.println("Total word count: " + wordCount.values().stream().mapToInt(Integer::intValue).sum());

        // Display the number of unique words
        System.out.println("Number of unique words: " + wordCount.size());

        // Display the frequency of each word
        System.out.println("Word frequencies:");
        wordCount.forEach((word, count) -> System.out.println(word + ": " + count));
    }

    // Method to read file content into a string
    private static String readFile(File file) {
        StringBuilder content = new StringBuilder();
        try (Scanner fileScanner = new Scanner(file)) {
            while (fileScanner.hasNextLine()) {
                content.append(fileScanner.nextLine()).append("\n");
            }
        } catch (FileNotFoundException e) {
            System.out.println("File not found: " + file.getAbsolutePath());
        }
        return content.toString();
    }

    // Method to count words in a given text
    private static Map<String, Integer> countWords(String text) {
        // Use a regular expression to split text by spaces and punctuation
        String[] words = text.toLowerCase().split("\\W+");

        Map<String, Integer> wordCount = new HashMap<>();
        for (String word : words) {
            if (!word.isEmpty() && !STOP_WORDS.contains(word)) {
                wordCount.put(word, wordCount.getOrDefault(word, 0) + 1);
            }
        }
        return wordCount;
    }
}
