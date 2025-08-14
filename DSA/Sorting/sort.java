
public class sort {

    public static void bubbleSort(int[] arr) {
        for (int i = 0 ; i < arr.length ; i++){
            for (int j = 0 ; j < arr.length-1 ; j++){
                if (arr[j] > arr[j+1]){
                    int temp = arr [j] ;
                    arr [j] = arr[j+1] ;
                    arr[j+1] = temp ;
                }
            }
        }
        printArray(arr);
    }

    public static void selectSort(int[] arr) {

        for (int i = 0 ; i < arr.length-1 ; i++){

            int min = i;

            for (int j = i+1 ; j<arr.length ; j++){
                if (arr[j] < arr[min]){
                    min = j ;
                };
            }
            int temp = arr[min] ;
            arr[min] = arr[i] ;
            arr[i] = temp ;
        }
        printArray(arr);
    }

    public static void insertSort(int[] arr) {

        for (int i = 1 ; i < arr.length ; i++){
            int curr = arr[i] ;
            int prev = i-1 ;

            while (prev >= 0 && arr[prev] > curr){
                arr[prev + 1] = arr[prev] ;
                prev -- ;
            }
            arr[prev + 1] = curr ;
        }
        printArray(arr);
    }

    public static void countSort(int[] arr){
        int largest = Integer.MIN_VALUE;
        for(int i = 0 ; i < arr.length ; i++){
            largest = Math.max(largest, arr[i]);
        }

        int count[] = new int[largest + 1];
        for(int i = 0 ; i < arr.length ; i++){
            count[arr[i]]++;
        }
        // sorting
        int j = 0;
        for (int i = 0; i < count.length; i++) {
            while(count[i] > 0){
                arr[j] = i ;
                j++;
                count[i]--;
            }
        }
        printArray(arr);
    }

    public static void printArray(int[] arr) {
        for (int i =0 ; i<arr.length ; i++){
            System.out.print(arr[i] + " ");
        }
    }

    public static void main(String[] args) {

        int [] arr = {5,4,1,3,2};

        // bubbleSort(arr);
        // selectSort(arr);
        // insertSort(arr);
        // Arrays.sort(arr);
        // printArray(arr);
        countSort(arr);
    }
}