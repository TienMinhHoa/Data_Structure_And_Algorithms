package week3;

import java.util.Scanner;

public class Uf2 {
    private static int[] root = new int[9999];

    public static int getRoot(int x) {
        while (root[x] > 0) {
            x = root[x];
        }
        return x;
    }


    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        for (int i = 1; i <= n; i++) {
            root[i] = -1;
        }

        int cnt = n;
        for (int i = 0; i < 4; i++) {
            int a = input.nextInt();
            int b = input.nextInt();
            int ra = getRoot(a);
            int rb = getRoot(b);
            if (getRoot(a) != getRoot(b)) {
                if (root[ra] < root[rb]) {
                    int tmp = root[rb];
                    root[rb] = ra;
                    root[ra] += tmp;
                } else {
                    int tmp = root[ra];
                    root[ra] = rb;
                    root[rb] += tmp;
                }
                cnt--;
            }
        }
        System.out.println(cnt);
    }
}
