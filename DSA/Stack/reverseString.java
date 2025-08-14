import java.util.*;

public class reverseString {
    public static String ReverseString(String str) {
        Stack<Character> stack = new Stack<>();
        for (char c : str.toCharArray()) {
            stack.push(c);
        }
        StringBuilder reversedStr = new StringBuilder();
        while (!stack.isEmpty()) {
            reversedStr.append(stack.pop());
        }
        return reversedStr.toString();
    }
    public static void main(String[] args) {
        String str = "Hello, World!";
        String reversedStr = ReverseString(str);
        System.out.println(reversedStr); // Output: !dlroW ,olleH
    }
}
