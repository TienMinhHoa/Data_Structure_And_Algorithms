import java.util.Scanner;
import java.util.Arrays;

public class newThreeSum {

    public static boolean contain_duplicate(int[] a){
        for(int i = 0; i < a.length-1; i++){
            if(a[i] == a[i+1]) return true;
        }
        return false;
    }
    public static int count(int[] a){
        int cnt = 0;
        for(int i = 0; i < a.length-1; i++){
            for(int j = i+1; j < a.length; j++){
                int tmp = binarySearch.bSearch(a,-(a[i]+a[j]));
                if(tmp!=-1) cnt++;
            }
        }
        return cnt;
    }
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        int[] array = new int[n];
        for(int i = 0; i < n; i++){
            array[i] = input.nextInt();
        }
        if(contain_duplicate(array)) throw new IllegalArgumentException("contain duplicated element");
        Arrays.sort(array,0,n);
        System.out.println(count(array));



    }
}
