public class mergeSort{
    public static void mergeSort(int[] arr, int l, int r) {
        if (l < r) {
            int m = l + (r - l) / 2; // (l+r)/2
            mergeSort(arr, l, m);
            mergeSort(arr, m + 1, r);
            merge(arr, l, m, r);
        }
    }
    public static void merge(int[] arr,int l, int m, int r){
        //method 1
        int temp[] = new int[r-l+1];
        int i = l, j = m+1, k = 0;

        while(i <= m && j <= r){
            if(arr[i] <= arr[j]){
                temp[k++] = arr[i++];
            }else{
                temp[k++] = arr[j++];
            }
        }
        while(i <= m){
            temp[k++] = arr[i++];
        }
        while(j <= r){
            temp[k++] = arr[j++];
        }
        for(int p = l; p <= r; p++){
            arr[p] = temp[p-l];
        }
        
        // // method 2
        // int n1 = m - l + 1;
        // int n2 = r - m;
        // int[] L = new int[n1];
        // int[] R = new int[n2];

        // for(int i = 0; i < n1; i++){
        //     L[i] = arr[l + i];
        // }
        // for(int j = 0; j < n2; j++){
        //     R[j] = arr[m + 1 + j];
        // }

        // int i = 0, j = 0;
        // int k = l;
        // while(i < n1 && j < n2){
        //     if(L[i] <= R[j]){
        //         arr[k] = L[i];
        //         i++;
        //     }else{
        //         arr[k] = R[j];
        //         j++;
        //     }
        //     k++;
        // }
        // while(i < n1){
        //     arr[k] = L[i];
        //     i++;
        //     k++;
        // }
        // while(j < n2){
        //     arr[k] = R[j];
        //     j++;
        //     k++;
        // }
    }
    public static void main(String[] args) {
        int[] arr = { 10, 7, 8, 9, 1, 5 };
        int n = arr.length;
        mergeSort(arr, 0, n - 1);
        System.out.println("Sorted array: ");
        for (int i = 0; i < n; i++) {
            System.out.print(arr[i] + " ");
        }
    }
}