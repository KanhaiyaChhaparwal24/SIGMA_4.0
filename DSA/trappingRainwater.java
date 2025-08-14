import java.util.*;

public class trappingRainwater {
  public int trap(int[] height) {
    // int left = 0, right = height.length - 1;
    // int leftMax = 0, rightMax = 0, ans = 0;

    // while (left <= right) {
    //   if (height[left] < height[right]) {
    //     if (height[left] >= leftMax) 
    //       leftMax = height[left];
    //     else 
    //       ans += leftMax - height[left];
    //     left++;
    //   } else {
    //     if (height[right] >= rightMax) 
    //       rightMax = height[right];
    //     else 
    //       ans += rightMax - height[right];
    //     right--;
    //   }
    // }
    // return ans;

    int leftMax[] = new int[height.length];
    leftMax[0] = height[0];
    for (int i = 1; i < height.length; i++) {
        leftMax[i] = Math.max(height[i],leftMax[i-1]);
    }

    int rightMax[] = new int[height.length];
    rightMax[height.length-1] = height[height.length-1];
    for (int i = height.length-2; i >= 0; i--) {
        rightMax[i] = Math.max(height[i],rightMax[i+1]);
    }

    int trappedWater = 0;
    for(int i = 0; i < height.length; i++) {
        int waterLevel = Math.min(leftMax[i],rightMax[i]);
        trappedWater += waterLevel - height[i];
    }

    return trappedWater;
  }

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    
    System.out.print("number of elements in height: ");
    int n = sc.nextInt();
    
    int[] height = new int[n];
    System.out.print("Enter the elements: ");
    for (int i = 0; i < n; i++) {
      height[i] = sc.nextInt();
    }
    
    trappingRainwater solution = new trappingRainwater();
    int result = solution.trap(height);
    
    System.out.println("Trapped rainwater: " + result);
    
    sc.close();
  }
}