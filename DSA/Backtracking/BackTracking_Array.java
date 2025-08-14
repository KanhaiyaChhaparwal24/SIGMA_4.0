public class BackTracking_Array{
    public static void changeArr(int arr[], int i, int value) {
        //base case
        if(i == arr.length) {
            System.out.print("Base Case: ");
            printArr(arr);
            return;
        }
        //recursive case
        arr[i] = value;
        changeArr(arr,i+1,value+1); //fnx call
        arr[i] = arr[i] - 2; //backtracking
    }

    public static void printArr(int arr[]) {
        for(int i=0;i<arr.length;i++) {
            System.out.print(arr[i]+" ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int arr[] = new int[5];
        changeArr(arr,0,1);
        System.out.print("Final Array: ");
        printArr(arr);
    }
}