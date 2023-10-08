package week5;

import java.io.*;
import java.util.*;

public class Queue {

    public static int[] queue = new int[100000];

    public static int n = -1;
    public static int m = 0;
    public static void add(int[] a,int i){
        queue[++n] = i;
    }

    public static int dequeue(int[] a){
        return a[m++];
    }

    public static void print(int[] a){
        System.out.println(a[m]);
    }

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner input = new Scanner(System.in);
        int q = input.nextInt();
        while(q>0){
            int i = input.nextInt();
            switch (i){
                case 1:{
                    int num = input.nextInt();
                    add(queue, num);
                    break;
                }
                case 2:{
                    dequeue(queue);
                    break;
                }
                case 3:{
                    print(queue);
                    break;
                }
            }
            q--;
        }

    }
}
