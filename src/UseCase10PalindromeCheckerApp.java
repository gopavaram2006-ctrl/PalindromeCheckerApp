/**
 * Use Case 10: Case-Insensitive & Space-Ignored Palindrome
 * Normalizes input by removing non-alphanumeric characters and lowercasing,
 * then checks palindrome by comparing symmetric characters.
 */
public class UseCase10PalindromeCheckerApp {
    public static void main(String[] args) {
        String input = "A man a plan a canal Panama";
        String normalized = normalize(input);
        boolean isPalindrome = check(normalized);
        System.out.println("Input : " + input);
        System.out.println("Is Palindrome? : " + isPalindrome);
    }

    private static String normalize(String s) {
        if (s == null) return "";
        // remove non-alphanumeric characters and convert to lowercase
        return s.replaceAll("[^A-Za-z0-9]", "").toLowerCase();
    }

    private static boolean check(String s) {
        int n = s.length();
        for (int i = 0; i < n / 2; i++) {
            if (s.charAt(i) != s.charAt(n - 1 - i)) return false;
        }
        return true;
    }
}
