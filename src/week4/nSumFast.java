package week4;
import edu.princeton.cs.algs4.In;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class nSumFast {
    static List<Integer> a = new ArrayList<Integer>();
    static List<Integer> b= new ArrayList<Integer>();
    static List<Integer> tmp1 = new ArrayList<Integer>();
    static List<Integer> tmp2 = new ArrayList<Integer>();
    public static void generate(int[] arr){
        tmp1.add(0);
        tmp2.add(0);
        for(int i = 0; i < arr.length; i++){
            if(i%2==0){
                a.add(arr[i]);
            }
            else {
                b.add(arr[i]);
            }
        }
        for(int i = 0; i < a.size(); i++){
            for(int j = 0; j < Math.pow(2,i); j++){
                tmp1.add(tmp1.get(j)+a.get(i));
            }
        }
        for(int i = 0; i < b.size(); i++){
            for(int j = 0; j < Math.pow(2,i); j++){
                tmp2.add(tmp2.get(j)+b.get(i));
            }
        }

    }
    public static void main(String[] args){
        int[] arr = {1,-1,0,2,-2};
        int cnt = -2;
        generate(arr);
        for(int i = 0; i < tmp1.size(); i++){
            if(tmp1.get(i) == 0){
                cnt++;
            }
        }
        for(int i = 0; i < tmp2.size(); i++){
            if(tmp2.get(i) == 0){
                cnt++;
            }
        }
        for(int i = 1; i < tmp1.size();i++){
            for(int j = 1; j < tmp2.size(); j++){
                if(tmp1.get(i)+tmp2.get(j) == 0){
                    cnt++;
                }
            }
        }
        System.out.println(cnt);

    }
}
