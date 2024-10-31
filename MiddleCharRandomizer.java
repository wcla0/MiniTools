package MiniTools;
import java.util.Random;
import java.util.Scanner;

public class MiddleCharRandomizer {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.println("Enter your string: ");
            String input = scanner.nextLine();
            String randomed = randMidChar(input);
            System.out.println("Original: " + input);
            System.out.println("Scrambled: " + randomed);
        }
    }

    public static String randMidChar(String input) {
        if (input.length() <= 2) {
            return input;
        }
        
        char firstChar = input.charAt(0);
        char lastChar = input.charAt(input.length() - 1);
        char[] middleChars = input.substring(1, input.length() - 1).toCharArray();
        
        Random random = new Random();
        for (int i = middleChars.length - 1; i > 0; i--) {
            int j = random.nextInt(i + 1);
            char temp = middleChars[i];
            middleChars[i] = middleChars[j];
            middleChars[j] = temp;
        }
        
        return firstChar + new String(middleChars) + lastChar;
    }
}