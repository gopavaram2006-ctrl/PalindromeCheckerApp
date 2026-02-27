public class PalindromeCheckerApp {
    public static void main(String[] args) {
        // UC1: Welcome message
        printWelcomeMessage();

        // UC2: Hardcoded palindrome check
        checkHardcodedPalindrome();

        // Additional use cases can be added here in the same class
        // (e.g., user input, file input, etc.)

        // UC8: Linked list palindrome check example
        checkLinkedListPalindrome("level");
    }

    // UC1: Display a welcome message to the user
    private static void printWelcomeMessage() {
        System.out.println("Welcome to the Palindrome Checker App!");
        System.out.println("This application can verify whether a given string is a palindrome.");
        System.out.println();
    }

    // UC2: Check a hardcoded palindrome string
    private static void checkHardcodedPalindrome() {
        String test = "racecar"; // hardcoded example
        System.out.println("UC2 - Hardcoded palindrome check:");
        System.out.println("  String to test: " + test);
        boolean result = isPalindrome(test);
        System.out.println("  Is palindrome? " + result);
        System.out.println();
    }

    // Utility method used by multiple use cases
    private static boolean isPalindrome(String input) {
        if (input == null) {
            return false;
        }
        String clean = input.replaceAll("\\s+", "").toLowerCase();
        int left = 0;
        int right = clean.length() - 1;
        while (left < right) {
            if (clean.charAt(left) != clean.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }

    // UC8: Linked List based palindrome check
    private static void checkLinkedListPalindrome(String input) {
        System.out.println("UC8 - Linked list palindrome check:");
        System.out.println("  Input: " + input);

        // build linked list of characters
        Node head = null;
        Node tail = null;
        for (char c : input.toCharArray()) {
            Node node = new Node(c);
            if (head == null) {
                head = tail = node;
            } else {
                tail.next = node;
                tail = node;
            }
        }

        boolean result = isPalindromeLinkedList(head);
        System.out.println("  Is palindrome? " + result);
        System.out.println();
    }

    // helper to check a linked list palindrome using fast/slow and reverse
    private static boolean isPalindromeLinkedList(Node head) {
        if (head == null || head.next == null) {
            return true;
        }
        // find middle using fast/slow pointers
        Node slow = head;
        Node fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        // slow is at mid (for odd length points to middle node)
        // reverse second half starting from slow
        Node second = reverseList(slow);
        Node first = head;
        // compare first half and reversed second half
        while (second != null) {
            if (first.data != second.data) {
                return false;
            }
            first = first.next;
            second = second.next;
        }
        return true;
    }

    private static Node reverseList(Node head) {
        Node prev = null;
        Node curr = head;
        while (curr != null) {
            Node next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }

    // simple node class for linked list characters
    private static class Node {
        char data;
        Node next;
        Node(char d) { data = d; }
    }
}
