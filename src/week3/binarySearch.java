package week3;

public class binarySearch {
    public static int bSearch(int[] a, int number) {
        int l = 0;
        int r = a.length - 1;
        while (l <= r) {
            int mid = l + (r - l) / 2;
            if (a[mid] > number) {
                r = mid-1;
            } else if (a[mid] < number) {
                l = mid+1;
            } else return mid;
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] a = new int[9];
        for (int i = 0; i < 9; i++) {
            a[i] = i;
        }
        System.out.println(bSearch(a, 10));
    }
}
