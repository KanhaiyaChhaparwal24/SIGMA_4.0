// Given two arrays: deadline[] and profit[], where the index of deadline[] represents a job ID, and deadline[i] denotes the deadline for that job and profit[i] represents profit of doing ith job. Each job takes exactly one unit of time to complete, and only one job can be scheduled at a time. A job earns its corresponding profit only if it is completed within its deadline.

// The objective is to determine:
//      The maximum profit that can be obtained by scheduling the jobs optimally.
//      The total number of jobs completed to achieve this maximum profit.

import java.util.*;

public class JobSequencing {
    static
    ArrayList<Integer> jobSequencing(int[] deadline, int[] profit) {
        int n = deadline.length;
        // total job count which is done
        int cnt = 0;
        // total profit earned
        int totProfit = 0;
        // pair the profit and deadline of all the jobs together
        ArrayList<int[]> jobs = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            jobs.add(new int[]{profit[i], deadline[i]});
        }
        // sort the jobs based on profit in decreasing order
        jobs.sort((a, b) -> Integer.compare(b[0], a[0]));
        // array to check time slot for job
        int[] slot = new int[n];
        for (int i = 0; i < n; i++) {
            int start = Math.min(n, jobs.get(i)[1]) - 1;
            for (int j = start; j >= 0; j--) {
                // if slot is empty
                if (slot[j] == 0) {
                    slot[j] = 1;
                    cnt++;
                    totProfit += jobs.get(i)[0];
                    break;
                }
            }
        }
        ArrayList<Integer> result = new ArrayList<>();
        result.add(cnt);
        result.add(totProfit);
        return result;
    }
    public static void main(String[] args) {
        int[] deadline = {2, 1, 2, 1, 1};
        int[] profit = {100, 19, 27, 25, 15};
        ArrayList<Integer> ans = jobSequencing(deadline, profit);
        System.out.println(ans.get(0) + " " + ans.get(1));
    }
}