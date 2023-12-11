package week4;

import java.util.Scanner;


public class NewYearChaos {
    public static void solve(int[] arr){
        int tmp = 0;
        int cnt = 0;
        for(int i = 0; i < arr.length; i++){
            if(arr[i]-i-1>2){
                System.out.println("Too chaotic");
                return;
            }
            for(int j = arr[i]-2; j < i;j++){
                    if(arr[j]>arr[i]){
                        cnt++;
                }
            }
        }
        System.out.println(cnt);
    }
    public static void main(String[] args){
        Scanner input= new Scanner(System.in);
        int t = input.nextInt();
        for(int i = 0; i < t; i++){
            int cnt = 0;
            int n = input.nextInt();
            int[] arr = new int[n];
            for(int j = 0; j < n; j++){
                arr[j] = input.nextInt();
            }
            solve(arr);
        }
    }
}
