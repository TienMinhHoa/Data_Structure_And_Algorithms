package Week6;

import java.util.Scanner;

public class QuickSort {
    public static int partition(int low, int high,int[] arr){
        int pivot = arr[low];
        int i = low;
        for(int j = low+1; j < high; j++){
            if(arr[j] < pivot){
                i++;
                int tmp = arr[j];
                arr[j] = arr[i];
                arr[i] = tmp;
            }
        }
        int tmp = arr[i];
        arr[i] = pivot;
        arr[low] = tmp;
        return i;
    }
    public static void sort(int[] arr,int low,int high){
        if(low < high){
            int part = partition(low,high,arr);
            sort(arr,low,part);
            sort(arr,part+1,high);
        }
    }

    public static void main(String args[]) {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        int[] arr = new int[n];
        for(int i = 0; i < n; i++){
            arr[i] = input.nextInt();
        }
        QuickSort ob = new QuickSort();
        ob.sort(arr,0,n);
        for(int i = 0; i < n; i++){
            System.out.println(arr[i]);;
        }
    }
}
