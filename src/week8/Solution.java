package week8;

import java.io.*;
import java.util.*;

public class Solution {
    public static int[] queue = new int[10000];
    static int cnt = 0;
    static int bot = 0;
    static int id = 1;


    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        int m = input.nextInt();
        for (int i = 0; i < m; i++) {
            int instruc = input.nextInt();
            if (instruc == 1) {
                queue[cnt++] = id;
                id++;
            } else if (instruc == 2) {
                if (cnt-bot < 1) {
                    System.out.println(0);
                } else {
                    System.out.println(queue[bot]);
                    bot++;
                }
            } else if (instruc == 3) {
                if (cnt-bot < 1) {
                    System.out.println(0);
                } else {
                    System.out.println(queue[cnt - 1]);
                    cnt--;
                }
            } else if (instruc == 4) {
                System.out.println(cnt - bot);
            } else if (instruc == 5) {
                int u = input.nextInt();
                System.out.println(queue[cnt-bot+u]);
            }
        }
    }
}