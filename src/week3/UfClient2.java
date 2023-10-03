package week3;

import edu.princeton.cs.algs4.WeightedQuickUnionUF;
import edu.princeton.cs.algs4.In;

public class UfClient2 {
    public static void main(String[] args){
        In in = new In(args[0]);
        int[] a = in.readAllInts();
        int n = a[0];
        WeightedQuickUnionUF uf = new WeightedQuickUnionUF(a[0]);
        for(int i = 1; i < a.length; i+=2){
            int s1 = a[i];
            int s2 = a[i+1];
            if(uf.find(s1)!=uf.find(s2)){
                n--;
                uf.union(s1,s2);
            }
            if(n==1) {
                System.out.println((int)(Math.ceil(i/2.0)));
                return;
            }

        }
        System.out.println("FAILED");
    }
}
