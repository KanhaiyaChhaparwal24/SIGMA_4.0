import java.util.*;

public class Classroom{
    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>();
        ArrayList<Integer> list2 = new ArrayList<>();

        // list.add(10); // O(1)
        // list.add(1,9); // O(n)
        // list.get(0); // O(1)
        // list.set(0, 20); // O(1)
        // list.remove(0); // O(n)
        // // list.clear(); // O(1)
        // System.out.println(list.contains(10)); // O(n)
        // System.out.println(list.size());
        // for(int i = 0; i < list.size(); i++){
        //     System.out.print(list.get(i) + " ");
        // }
        // System.out.println(list); 

        list2.add(2);
        list2.add(5);
        list2.add(9);
        list2.add(6);
        list2.add(8);

        int max = Integer.MIN_VALUE;
        for (int i = 0; i < list2.size(); i++) {
            // if(max < list2.get(i)){
            //     max = list2.get(i);
            // }
            max = Math.max(max, list2.get(i));
        }
        System.out.println("Max Element: "+ max);

        System.out.println(list2);
        Collections.sort(list2); // ascending order // O(nlogn)
        System.out.println(list2);
        Collections.sort(list2, Collections.reverseOrder()); // descending order 
        System.out.println(list2);
        Collections.shuffle(list2); // shuffle the list
        System.out.println(list2);
        Collections.reverse(list2); // reverse the list
        System.out.println(list2);
        
    }
}