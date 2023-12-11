package Week6;

import java.util.Scanner;

public class SelfPriority {

    int[] arr = new int[99999999];
    int size = 0;

    public boolean isEmpty() {
        return size == 0;
    }

    public int peek() {
        if (isEmpty()) {
            return -1;
        }
        return arr[1];
    }

    public void add(int a) {
        arr[++size] = a;
        int curr = size;
        int par = size / 2;
        while (par != 0 && arr[curr] <= arr[par]) {
            int tmp = arr[curr];
            arr[curr] = arr[par];
            arr[par] = tmp;
            curr = par;
            par /= 2;
        }
    }

    public int poll() {
        if (isEmpty()) {
            return -1;
        }
        int root = arr[1];
        arr[1] = arr[size];
        size--;
        int curr = 1;
        while (2 * curr <= size) {
            int left = 2 * curr;
            int right = left + 1;
            int smaller = left;
            if (right <= size && arr[left] >= arr[right]) {
                smaller = right;
            }
            if (arr[curr] > arr[smaller]) {
                int tmp = arr[curr];
                arr[curr] = arr[smaller];
                arr[smaller] = tmp;
            }
            curr = smaller;
        }
        return root;
    }

    public static void main(String[] args) {
        SelfPriority queue = new SelfPriority();
        Scanner input = new Scanner(System.in);
        long n = input.nextLong();
        long k = input.nextLong();
        for (long i = 0; i < n; i++) {
            int tmp = input.nextInt();
            queue.add(tmp);
        }
        long cnt = 0;
        while (queue.peek() < k) {
            if (queue.size == 1) {
                System.out.println(-1);
                return;
            }
            int c1 = queue.poll();
            int c2 = queue.poll();
            queue.add(c1 + c2 * 2);
            cnt++;
        }
        System.out.println(cnt);

    }
}

