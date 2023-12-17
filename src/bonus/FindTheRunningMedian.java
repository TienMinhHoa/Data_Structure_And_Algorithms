package bonus;

import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Scanner;

public class FindTheRunningMedian {

    public static void main(String[] args) {
        PriorityQueue<Integer> smallHeap = new PriorityQueue<>(Collections.reverseOrder());
        PriorityQueue<Integer> largeHeap = new PriorityQueue<>();
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        for(int i = 0; i < n; i++){
            int v= input.nextInt();
            if(largeHeap.isEmpty()||v>largeHeap.peek()){
                largeHeap.offer(v);
            }
            else{
                smallHeap.offer(v);
            }

            if(largeHeap.size()>smallHeap.size()+1){
                smallHeap.offer(largeHeap.poll());
            }
            if(smallHeap.size() > largeHeap.size()+1){
                largeHeap.offer(smallHeap.poll());
            }

            if(largeHeap.size()> smallHeap.size()){
                System.out.println(largeHeap.peek());
            }
            else if(largeHeap.size()<smallHeap.size()){
                System.out.println(smallHeap.peek());
            }
            else{
                System.out.println(0.5*(largeHeap.peek()+smallHeap.peek()));
            }

        }
    }
}