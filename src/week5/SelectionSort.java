package week5;
import edu.princeton.cs.algs4.In;

public class SelectionSort {
    public static void selectionSort(int[] a){
        for(int i = 0; i < a.length-1; i++){
            int min = a[i];
            int index = i;
            for(int j = i+1; j < a.length;j++){
                if(min>a[j]){
                    min = a[j];
                    index = j;
                }
            }
            int tmp = min;
            a[index] = a[i];
            a[i] = min;
        }
    }
    public static void main(String[] args) {
        String[] tmp = {"D:\\java_code\\algs4-data\\8Kints.txt", "D:\\java_code\\algs4-data\\16Kints.txt", "D:\\java_code\\algs4-data\\32Kints.txt"};
        for (int j = 0; j < 12; j++) {
            In in = new In(tmp[j%3]);
            int[] a = in.readAllInts();
            long start = System.currentTimeMillis();
            selectionSort(a);
            long end = System.currentTimeMillis();
            System.out.printf("%d: %d\n",j,end - start);
        }
    }
}
