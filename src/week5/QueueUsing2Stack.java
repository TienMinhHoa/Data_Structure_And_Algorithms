package week5;

import java.util.Stack;

import java.util.Scanner;

public class QueueUsing2Stack {
    public static int[] arr = new int[9999999];
    public static int bot = 0;
    public static int top = 0;

    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        for(int i = 0; i < n;i++){
            int in = input.nextInt();
            if(in == 1){
                int x = input.nextInt();
                arr[top++] = x;
            } else if(in == 2){
                bot++;
            } else if(in == 3){
                System.out.println(arr[bot]);
            }
        }
    }
}
