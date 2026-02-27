/**
 * Use Case 11: Object-Oriented Palindrome Service
 * Encapsulates palindrome logic inside a service class.
 */
public class UseCase11PalindromeCheckerApp {
    public static void main(String[] args) {
        String input = "racecar";
        PalindromeService service = new PalindromeService();
        boolean result = service.checkPalindrome(input);
        System.out.println("Input : " + input);
        System.out.println("Is Palindrome? : " + result);
    }
}

/**
 * Service class that contains palindrome logic.
 */
class PalindromeService {
    /**
     * Checks whether the input string is a palindrome.
     * Leading/trailing spaces are trimmed; check is case-sensitive per UC11.
     * @param input Input string
     * @return true if palindrome, false otherwise
     */
    public boolean checkPalindrome(String input) {
        if (input == null) return false;
        String s = input.trim();
        int start = 0;
        int end = s.length() - 1;
        while (start < end) {
            if (s.charAt(start) != s.charAt(end)) return false;
            start++;
            end--;
        }
        return true;
    }
}
