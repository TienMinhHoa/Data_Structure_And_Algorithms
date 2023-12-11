package week8;

import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class Threesumm_review {
    public static boolean containDuplicates(int[] a){
        for(int i = 0; i < a.length-1; i++)
        {
            if(a[i] == a[i+1]) return false;
        }
        return false;
    }
    public static void main(String[] args){
        int cnt = 0;
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        int[] a = new int[n];
        for(int i = 0; i < n; i++){
            a[i] = input.nextInt();
        }
        Arrays.sort(a,0,a.length);

        for(int i = 0; i < n -2; i++){
            int j = i+1;
            for(int k = n-1; k >i; k--){
                while(j < k){
                    if(a[i]+a[j]+a[k] == 0){
                        cnt++;
                        j+=1;
                        k-=1;
                        break;
                    }
                    else if(a[i]+a[j]+a[k] >0){
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
