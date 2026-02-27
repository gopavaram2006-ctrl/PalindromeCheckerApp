import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Stack;

/**
 * Use Case 12: Strategy Pattern for Palindrome Algorithms
 * Provides two interchangeable strategies: StackStrategy and DequeStrategy.
 */
public class UseCase12PalindromeCheckerApp {
    public static void main(String[] args) {
        String input = "level";
        String chosen = (args.length > 0) ? args[0] : "stack";

        PalindromeStrategy strategy;
        if ("deque".equalsIgnoreCase(chosen)) {
            strategy = new DequeStrategy();
        } else {
            strategy = new StackStrategy();
        }

        System.out.println("Using strategy: " + strategy.getClass().getSimpleName());
        boolean result = strategy.check(input);
        System.out.println("Input : " + input);
        System.out.println("Is Palindrome? : " + result);
    }
}

/**
 * Strategy interface for palindrome checking algorithms.
 */
interface PalindromeStrategy {
    boolean check(String input);
}

/**
 * Stack-based implementation: pushes characters then pops to compare.
 */
class StackStrategy implements PalindromeStrategy {
    @Override
    public boolean check(String input) {
        if (input == null) return false;
        Stack<Character> stack = new Stack<>();
        for (char c : input.toCharArray()) stack.push(c);
        for (char c : input.toCharArray()) {
            if (stack.pop() != c) return false;
        }
        return true;
    }
}

/**
 * Deque-based implementation: compares from both ends using a deque.
 */
class DequeStrategy implements PalindromeStrategy {
    @Override
    public boolean check(String input) {
        if (input == null) return false;
        Deque<Character> dq = new ArrayDeque<>();
        for (char c : input.toCharArray()) dq.addLast(c);
        while (dq.size() > 1) {
            if (dq.removeFirst() != dq.removeLast()) return false;
        }
        return true;
    }
}
