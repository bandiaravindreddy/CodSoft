import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class WordCounter {
    private static final Set<String> STOP_WORDS = new HashSet<>(Arrays.asList(
            "a", "an", "and", "the", "in", "on", "at", "to", "for", "of", "with", "is", "are", "was", "were"));

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Step 1: Prompt user for text input or file input
        System.out.println("Enter 'text' to input text manually or 'file' to provide a file:");
        String inputChoice = scanner.nextLine();

        String text = "";

        // Step 2: Read input text or file and store it in a string
        if (inputChoice.equalsIgnoreCase("text")) {
            System.out.println("Enter your text:");
            text = scanner.nextLine();
        } else if (inputChoice.equalsIgnoreCase("file")) {
            System.out.println("Enter the file path:");
            String filePath = scanner.nextLine();
            text = readFromFile(filePath);
        } else {
            System.out.println("Invalid choice. Please enter 'text' or 'file'.");
            System.exit(1);
        }

        // Step 3: Split the string into an array of words using space or punctuation as delimiters
        String[] words = text.split("[\\s\\p{Punct}]+");

        // Step 4: Initialize a counter variable to keep track of the number of words
        int wordCount = 0;
        Map<String, Integer> wordFrequency = new HashMap<>();

        // Step 5: Iterate through the array of words and increment the counter for each word encountered
        for (String word : words) {
            // Step 7: Ignore common words or stop words
            if (!STOP_WORDS.contains(word.toLowerCase())) {
                wordCount++;
                // Step 8: Calculate word frequency
                wordFrequency.put(word.toLowerCase(), wordFrequency.getOrDefault(word.toLowerCase(), 0) + 1);
            }
        }

        // Step 6: Display the total count of words to the user
        System.out.println("Total word count: " + wordCount);

        // Step 8: Display word frequency statistics
        System.out.println("\nWord Frequency:");
        for (Map.Entry<String, Integer> entry : wordFrequency.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }

        scanner.close();
    }

    // Method to read text from file
    private static String readFromFile(String filePath) {
        StringBuilder sb = new StringBuilder();
        try {
            File file = new File(filePath);
            Scanner fileScanner = new Scanner(file);
            while (fileScanner.hasNextLine()) {
                sb.append(fileScanner.nextLine()).append("\n");
            }
            fileScanner.close();
        } catch (FileNotFoundException e) {
            System.out.println("File not found.");
            System.exit(1);
        }
        return sb.toString();
    }
}