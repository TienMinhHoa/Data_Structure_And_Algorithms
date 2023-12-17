package bonus;

import java.util.Scanner;

public class ReturnShore4 {
    static long[] arr = new long[10000002];
    static long[] a = new long[1000002];

    public static void build(int l, int r,int id){
        if(l == r){
            arr[id] = a[l];
            return;
        }
        int mid = (l+r)/2;
        build(l,mid,id*2);
        build(mid+1,r,id*2+1);

        arr[id] = Math.max(arr[2*id],arr[2*id+1]);
    }

    public static long find(int l, int r, int id, int u,int v){
        if(v < l||u>r){
            return -1000000;
        }
        if(l>=u&&r<=v){
            return arr[id];
        }
        int mid = (l+r)/2;
        long find1 = find(l,mid,2*id,u,v);
        long find2 = find(mid+1,r,2*id+1,u,v);
        return Math.max(find1,find2);
    }

    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        for(int i = 1; i <=n; i++){
            a[i] = input.nextLong();
        }
        build(1,n,1);
        long q = input.nextLong();
        for(int i = 0; i < q; i++){
            int u = input.nextInt();
            int v = input.nextInt();
            System.out.println(find(1,n,1,u,v));
        }
    }
}
