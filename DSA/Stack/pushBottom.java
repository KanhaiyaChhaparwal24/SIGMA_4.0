import java.util.*;

public class pushBottom {
    public static void pushAtBottom(Stack<Integer> s, int data) {
        if (s.isEmpty()) {
            s.push(data);
            return;
        }
        int top = s.pop();
        pushAtBottom(s, data);
        s.push(top);
    }
    public static void main(String[] args) {
        Stack<Integer> s = new Stack<>();
        s.push(1);
        s.push(2);
        s.push(3);

        System.out.println(s); // Output: [1, 2, 3]
        pushAtBottom(s, 4);
        System.out.println(s); // Output: [4, 1, 2, 3]
    }
}