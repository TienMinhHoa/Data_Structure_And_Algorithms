package bonus;

import java.util.*;

public class ReturnShore2 {
    static PriorityQueue<Long> arr = new PriorityQueue<>();

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        Long n = input.nextLong();
        Long k = input.nextLong();
        if(n<k){
            System.out.println(0);
            return;
        }
        long sum = 0;
        for (int i = 0; i < n; i++) {
            Long v = input.nextLong();
            if(i+1 > k && arr.peek()<v){
                sum = sum - arr.poll() +v;
                arr.add(v);
                System.out.print(sum+" ");
            }
            else if(i+1<=k){
                arr.offer(v);
                sum+=v;
                System.out.print(sum+" ");
            }
            else{
                System.out.print(sum+" ");
            }
        }
    }
}

