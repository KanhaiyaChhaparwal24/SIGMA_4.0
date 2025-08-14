public class manipulation {
    
    
    public static void OddOrEven(int n) {
        if ((n & 1) == 0) {
            System.out.println(n + " is even");
        } else {
            System.out.println(n + " is odd");
        }
    }
    public static int getIthBit(int n, int i) {
        return (n & (1 << i)) == 0 ? 0 : 1;
    }
    public static int setIthBit(int n, int i) {
        return n | (1 << i);
    }
    public static int clearIthBit(int n, int i) {
        int mask = ~(1 << i);
        return n & mask;
    }
    public static int UpdateIthBit(int n, int i, int v) {
        int mask = ~(1 << i);
        return (n & mask) | (v << i);
    }
    public static int clearLastIBits(int n, int i) {
        int mask = (-1 << i);
        return n & mask;
    }
    public static int clearLastIBits(int n, int i, int j) {
        int a = (-1 << j + 1);
        int b = (1 << i) - 1;
        int mask = a | b;
        return n & mask;
    }

    public static boolean isPowerOfTwo(int n) {
        return n != 0 && (n & (n - 1)) == 0;
    }
    public static int countSetBits(int n) {
        int count = 0;
        while (n > 0) {
            n = n & (n - 1);
            count++;
        }
        return count;
    }
    public static int fastExponentiation(int a, int n) {
        int ans = 1;
        while (n > 0) {
            int lastBit = (n & 1);
            if (lastBit == 1) {
                ans = ans * a;
            }
            a = a * a;
            n = n >> 1;
        }
        return ans;
    }

    public static void main(String[] args) {
        // int a = 5;  // 0101 in binary
        // int b = 3;  // 0011 in binary

        // // AND operator
        // int andResult = a & b;  // 0001 in binary, which is 1
        // System.out.println("AND Operation: " + andResult);

        // // OR operator
        // int orResult = a | b;  // 0111 in binary, which is 7
        // System.out.println("OR Operation: " + orResult);

        // // XOR operator
        // int xorResult = a ^ b;  // 0110 in binary, which is 6
        // System.out.println("XOR Operation: " + xorResult);

        // // NOT operator
        // int notResult = ~a;  // 1010 in binary (2's complement), which is -6
        // System.out.println("NOT Operation: " + notResult);

        // // Left shift operator
        // int leftShiftResult = a << 1;  // 1010 in binary, which is 10
        // System.out.println("Left Shift Operation: " + leftShiftResult);

        // // Right shift operator
        // int rightShiftResult = a >> 1;  // 0010 in binary, which is 2
        // System.out.println("Right Shift Operation: " + rightShiftResult);

        // // Unsigned right shift operator
        // int unsignedRightShiftResult = a >>> 1;  // 0010 in binary, which is 2
        // System.out.println("Unsigned Right Shift Operation: " + unsignedRightShiftResult);

        System.out.println(fastExponentiation(3, 5));
    }
}