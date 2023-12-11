package Week9;

import java.util.Scanner;

public class ConnectedCells {
    private static class Uf {
        public int[] root;

        public Uf(int n) {
            root = new int[9999999];
            for (int i = 0; i < 999999; i++) {
                root[i] = -1;
            }
        }


        public int getRoot(int a) {
            while (root[a] >= 0) {
                a = root[a];
            }
            return a;
        }

        public boolean isConnected(int a, int b) {
            return getRoot(a) == getRoot(b);
        }

        public int count(int a) {
            return -root[getRoot(a)];
        }

        public void connect(int a, int b) {
            if (isConnected(a, b)) {
                return;
            }
            int ra = getRoot(a);
            int rb = getRoot(b);
            if (root[ra] > root[rb]) {
                int tmp = root[ra];
                root[ra] = rb;
                root[rb] += tmp;
            } else {
                int tmp = root[rb];
                root[rb] = ra;
                root[ra] += tmp;
            }
        }
    }


    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        int m = input.nextInt();
        int[] arr = new int[n * m];
        Uf uf = new Uf(m * n);
        for (int i = 0; i < n * m; i++) {
            arr[i] = input.nextInt();
        }
        int max = -99999;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                int index = i * m + j;
                int right = i * m + j + 1;
                int down = (i + 1) * m + j;
                int diag = (i + 1) * m + j + 1;
                int root = uf.getRoot(index);


                if (i < n - 1 && j < m - 1 && arr[index] == arr[diag] && !uf.isConnected(index, diag)&&arr[index] == 1) {
                    uf.connect(index, diag);
                }
                if (i < n - 1 && arr[index] == arr[down] && !uf.isConnected(index, down)&&arr[index] == 1) {
                    uf.connect(index, down);
                }
                if (j < m - 1 && arr[index] == arr[right] && !uf.isConnected(index, right)&&arr[index] == 1) {
                    uf.connect(index, right);
                }
                if(j < m-1 && i <n-1 && arr[right] == arr[down]&& arr[right] == 1 && !uf.isConnected(right,down)){
                    uf.connect(right,down);
                }
                if(j < m-1 && i <n-1 && arr[diag] == arr[down]&& arr[diag] == 1 && !uf.isConnected(diag,down)){
                    uf.connect(diag,down);
                }
                if(j < m-1 && i <n-1 && arr[diag] == arr[right]&& arr[diag] == 1 && !uf.isConnected(diag,right)){
                    uf.connect(diag,right);
                }


                if (uf.count(index) > max) {
                    max = uf.count(index);
                }
            }
        }
        System.out.println(max);
    }
}
