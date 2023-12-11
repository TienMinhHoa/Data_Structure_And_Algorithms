package week8;

import edu.princeton.cs.algs4.In;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class nSum {
    public static List<Integer> a = new ArrayList<>();
    public static List<Integer> b = new ArrayList<>();
    public static List<Integer> tmp1 = new ArrayList<>();
    public static List<Integer> tmp2 = new ArrayList<>();

    public static void generate(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            if (i % 2 == 0) {
                a.add(arr[i]);
            } else {
                b.add(arr[i]);
            }
        }
        tmp1.add(0);
        tmp2.add(0);
        for (int i = 0; i < a.size(); i++) {
            for (int j = 0; j < Math.pow(2, i); j++) {
                tmp1.add(tmp1.get(j) + a.get(i));
            }
        }

        for (int i = 0; i < b.size(); i++) {
            for (int j = 0; j < Math.pow(2, i); j++) {
                tmp2.add(tmp2.get(j) + a.get(i));
            }
        }
    }

    public static boolean biSearch(List<Integer> a, int target) {
        int l = 0;
        int r = a.size() - 1;
        int mid = 0;
        while(l<=r){
            mid = l + (r - l) / 2;
            if(target>a.get(mid)){
                l = mid+1;
            }
            else if(a.get(mid) > target){
                r = mid-1;
            }
            else{
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        In in = new In("D:\\java_code\\algs4-data\\8ints.txt");
        int[] a = in.readAllInts();
        generate(a);
        for(int i = 0; i < a.length; i++)
            System.out.println(a[i]);
        int cnt = -2;
        Collections.sort(tmp1);
        Collections.sort(tmp2);
        for(int i = 0; i < tmp1.size();i++){
            if(tmp1.get(i) == 0){
                cnt++;
            }
            else if(tmp1.get(i)>0){
                break;
            }
        }
        for(int i = 0; i < tmp2.size();i++){
            if(tmp2.get(i) == 0){
                cnt++;
            }
            else if(tmp2.get(i)>0){
                break;
            }
        }
        for(int i = 0; i < tmp1.size();i++){
            if(biSearch(tmp2,-tmp1.get(i))){
                cnt++;
            }
        }
        System.out.println(cnt);
    }
}
