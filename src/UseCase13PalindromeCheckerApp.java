import java.util.Stack;

/**
 * Use Case 13: Performance Comparison
 * Measures execution time of several palindrome algorithms.
 */
public class UseCase13PalindromeCheckerApp {
    public static void main(String[] args) {
        String input = "level";
        int iterations = 10000; // run each algorithm many times for measurable timing

        // warm up
        twoPointer(input);
        reverseBuilder(input);
        stackMethod(input);

        System.out.println("Input : " + input);

        long start, end;

        start = System.nanoTime();
        boolean res1 = false;
        for (int i = 0; i < iterations; i++) res1 = twoPointer(input);
        end = System.nanoTime();
        System.out.println("Two-Pointer: " + res1 + " | Execution Time : " + (end - start) + " ns");

        start = System.nanoTime();
        boolean res2 = false;
        for (int i = 0; i < iterations; i++) res2 = reverseBuilder(input);
        end = System.nanoTime();
        System.out.println("StringBuilder Reverse: " + res2 + " | Execution Time : " + (end - start) + " ns");

        start = System.nanoTime();
        boolean res3 = false;
        for (int i = 0; i < iterations; i++) res3 = stackMethod(input);
        end = System.nanoTime();
        System.out.println("Stack Method: " + res3 + " | Execution Time : " + (end - start) + " ns");
    }

    // two-pointer approach
    private static boolean twoPointer(String s) {
        if (s == null) return false;
        int i = 0, j = s.length() - 1;
        while (i < j) {
            if (s.charAt(i) != s.charAt(j)) return false;
            i++; j--;
        }
        return true;
    }

    // using StringBuilder reverse
    private static boolean reverseBuilder(String s) {
        if (s == null) return false;
        return s.equals(new StringBuilder(s).reverse().toString());
    }

    // stack-based approach
    private static boolean stackMethod(String s) {
        if (s == null) return false;
        Stack<Character> st = new Stack<>();
        for (char c : s.toCharArray()) st.push(c);
        for (char c : s.toCharArray()) {
            if (st.pop() != c) return false;
        }
        return true;
    }
}
