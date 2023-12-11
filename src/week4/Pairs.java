package week4;

import edu.princeton.cs.algs4.In;

import java.util.Hashtable;
import java.util.Scanner;

public class Pairs {
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        int k = input.nextInt();
        int[] arr = new int[n];
        for(int i = 0; i < n; i++){
            arr[i] = input.nextInt();
        }
        Hashtable<Integer,Integer> dict = new Hashtable<>();
        for(int i = 0; i < n; i++){
            dict.put(arr[i],1);
        }
        int cnt = 0;
        for(int i = 0; i < n;i++){
            if(dict.containsKey(arr[i]+k)){
                cnt++;
            }
        }
        System.out.println(cnt);
    }
}
