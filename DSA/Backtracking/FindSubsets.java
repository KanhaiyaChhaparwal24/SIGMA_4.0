public class FindSubsets {
    public static void findSubsets(String str, String current, int i) {
        //base case
        if(i == str.length()) {
            System.out.println(current);
            return;
        }
        //recursive case
        // no
        findSubsets(str,current,i+1); //fnx call without including current character
        // yes
        findSubsets(str,current+str.charAt(i),i+1); //fnx call including current character
    }

    public static void main(String[] args) {
        String str = "abc";
        findSubsets(str,"",0);

    }
}