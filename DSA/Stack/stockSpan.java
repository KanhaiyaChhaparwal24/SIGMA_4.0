import java.util.Stack;

public class stockSpan {
    public static int[] calculateSpan(int[] prices) {
        int n = prices.length;
        int[] span = new int[n];
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < n; i++) {
            // Pop elements from the stack while the stack is not empty and the current price is greater
            // than the price at the index stored at the top of the stack
            while (!stack.isEmpty() && prices[stack.peek()] <= prices[i]) {
                stack.pop();
            }

            // If the stack is empty, it means the current price is greater than all previous prices
            span[i] = (stack.isEmpty()) ? (i + 1) : (i - stack.peek());

            // Push the current index onto the stack
            stack.push(i);
        }

        return span;
    }

    public static void main(String[] args) {
        int[] prices = {100, 80, 60, 70, 60, 85, 100};
        int[] span = calculateSpan(prices);

        for (int s : span) {
            System.out.print(s + " ");
        }
    }
}
