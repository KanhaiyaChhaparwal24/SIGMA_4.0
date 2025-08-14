import java.util.Stack;

public class nextGreater {
    public static void main(String[] args) {
        int[] arr = {6, 8, 0, 1, 3};
        int[] result = nextGreaterElement(arr);

        for (int i : result) {
            System.out.print(i + " ");
        }
    }

    public static int[] nextGreaterElement(int[] arr) {
        int[] result = new int[arr.length];
        Stack<Integer> stack = new Stack<>();

        for (int i = arr.length - 1; i >= 0; i--) {
            // Remove elements from the stack that are smaller or equal to the current element
            while (!stack.isEmpty() && stack.peek() <= arr[i]) {
                stack.pop();
            }

            // If the stack is empty, no greater element exists
            result[i] = stack.isEmpty() ? -1 : stack.peek();

            // Push the current element onto the stack
            stack.push(arr[i]);
        }

        return result;
    }
}
