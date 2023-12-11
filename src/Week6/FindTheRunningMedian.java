package Week6;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Scanner;

public class FindTheRunningMedian {
    public static PriorityQueue<Integer> maxHeap = new PriorityQueue<>();
    public static PriorityQueue<Integer> minHeap = new PriorityQueue<>(Comparator.reverseOrder());
    public static double solve(int a){
        if(maxHeap.isEmpty()||a > maxHeap.peek()){
            maxHeap.add(a);
        } else{
            minHeap.add(a);
        }
        if(maxHeap.size()-1>minHeap.size()){
            int tmp = maxHeap.poll();
            minHeap.add(tmp);
        } else if(minHeap.size()-1>maxHeap.size()){
            int tmp = minHeap.poll();
            maxHeap.add(tmp);
        }
        int num  = maxHeap.size()+minHeap.size();
        if(num%2 ==0){
            int tmp1 = maxHeap.peek();
            int tmp2 = minHeap.peek();
            double res = (tmp1+tmp2)/2.0;
            return res;
        } else{
            double res = (maxHeap.size()>minHeap.size()) ? maxHeap.peek():minHeap.peek();
            return res;
        }
    }
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        for(int i = 0; i < n; i++){
            int a = input.nextInt();
            System.out.println(solve(a));
        }


    }
}
