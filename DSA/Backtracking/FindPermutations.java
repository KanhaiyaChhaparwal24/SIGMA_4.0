public class FindPermutations {
    public static void findPermutations(String str, String ans) {
        //base case
        if(str.length() == 0) {
            System.out.println(ans);
            return;
        }
        //recursive case
        for(int i=0;i<str.length();i++) {
            char ch = str.charAt(i);
            String NewStr = str.substring(0,i) + str.substring(i+1);
            findPermutations(NewStr, ans + ch);
        }
    }

    public static void main(String[] args) {
        String str = "abc";
        findPermutations(str,"");
    }
}
