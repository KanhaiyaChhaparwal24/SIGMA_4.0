public class Strings {

    public static boolean isPalindrome(String str) {
        int i = 0;
        int j = str.length() - 1;
        while (i < j) {
            if (str.charAt(i) != str.charAt(j)) {
                return false;
            }
            i++;
            j--;
        }
        return true;
    }

    public static float getShortestPath(String path) {
        int x = 0;
        int y = 0;
        for (int i = 0; i < path.length(); i++) {
            if (path.charAt(i) == 'N') {
                y++;
            } else if (path.charAt(i) == 'S') {
                y--;
            } else if (path.charAt(i) == 'E') {
                x++;
            } else if (path.charAt(i) == 'W') {
                x--;
            }
        }
        int X2 = x * x;
        int Y2 = y * y;
        return (float) Math.sqrt(X2 + Y2);
    }

    public static String toUpperCase(String str) {
        StringBuilder sb = new StringBuilder("");
        // for (int i = 0; i < str.length(); i++) {
        //     char c = str.charAt(i);
        //     if (c >= 'a' && c <= 'z') {
        //         c = (char) (c - 'a' + 'A');
        //     }
        //     sb.append(c);
        // }
        // return sb.toString();
        char ch = Character.toUpperCase(str.charAt(0));
        sb.append(ch);
        for (int i = 1; i < str.length(); i++) {
            if (str.charAt(i) == ' ' && i < str.length() - 1) {
                sb.append(str.charAt(i));
                i++;
                sb.append(Character.toUpperCase(str.charAt(i)));
            } else {
                sb.append(str.charAt(i));
            }
        }
        return sb.toString();
    }

    public static String compress(String str){
        String newStr = "";
        for (int i = 0; i < str.length(); i++) {
            Integer count = 1;
            while (i < str.length() - 1 && str.charAt(i) == str.charAt(i + 1)) {
                count++;
                i++;
            }
            newStr += str.charAt(i);
            if (count > 1) {
                newStr += count.toString();
            }
        }
        return newStr;
    }

    public static void main(String[] args) {
        // String str = "racecar";
        // System.out.println(isPalindrome(str));
        // String path = "WNEENESENNN";
        // System.out.println(getShortestPath(path));

        // StringBuilder sb = new StringBuilder();
        // for (char c = 'a'; c <= 'z'; c++) {
        //     sb.append(c);
        // }
        // System.out.println(sb);

        // String str = "hi, i am string";
        // System.out.println(toUpperCase(str));

        String str = "aaabbcccdd";
        System.out.println(compress(str));
    }
}