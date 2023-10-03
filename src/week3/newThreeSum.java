package week3;

import java.util.Scanner;
import java.util.Arrays;
import edu.princeton.cs.algs4.In;

public class newThreeSum {

    public static boolean contain_duplicate(int[] a) {
        for (int i = 0; i < a.length - 1; i++) {
            if (a[i] == a[i + 1]) return true;
        }
        return false;
    }

    public static int count(int[] a) {
        int cnt = 0;
        for (int i = 0; i < a.length - 1; i++) {
            for (int j = i + 1; j < a.length; j++) {
                int tmp = binarySearch.bSearch(a, -(a[i] + a[j]));
                if (tmp != -1 && tmp > j) cnt++;
            }
        }
        return cnt;
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        int[] a = new int[n];
        for(int i = 0; i < n; i++){
            a[i] = input.nextInt();
        }
        if (contain_duplicate(a)) throw new IllegalArgumentException("contain duplicated element");
        Arrays.sort(a, 0, a.length);
        System.out.println(count(a));
        int cnt = 0;
        for(int i = 0; i < a.length-2; i++){
            int j = i+1;
            for(int k = a.length-1; k > i+1; k--){
                while(j < k){
                    if(a[i]+a[j]+a[k] == 0){
                        cnt++;
                        k -= 1;
                        j+=1;
                        break;
                    }
                    else if(a[i]+a[j]+a[k] > 0){
                        break;
                    }
                    else{
                        j+=1;
                    }
                }
            }
        }
        System.out.println(cnt);


    }
}
