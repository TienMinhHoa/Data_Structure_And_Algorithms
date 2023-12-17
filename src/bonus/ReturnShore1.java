package bonus;

import java.io.*;
import java.util.*;

public class ReturnShore1 {
    static PriorityQueue<Integer> smallHeap = new PriorityQueue<>(Collections.reverseOrder());
    static PriorityQueue<Integer> largeHeap = new PriorityQueue<>();
    static void add(int a){
        if(largeHeap.isEmpty()||a>largeHeap.peek()){
            largeHeap.offer(a);
        }
        else{
            smallHeap.offer(a);
        }
        if(largeHeap.size()>smallHeap.size()+1){
            smallHeap.offer(largeHeap.poll());
        }
        else if(smallHeap.size()>largeHeap.size()+1){
            largeHeap.offer(smallHeap.poll());
        }
    }
    static int find(){
        if(largeHeap.isEmpty() && smallHeap.isEmpty()){
            return 0;
        }
        if(largeHeap.size()>smallHeap.size()){
            return largeHeap.peek();
        }
        return smallHeap.peek();
    }
    static void remove(){
        if(largeHeap.size()>smallHeap.size()){
            largeHeap.poll();
            return;
        }
        smallHeap.poll();
    }

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        int m = input.nextInt();
        for(int i = 0; i < n; i++){
            int v = input.nextInt();
            add(v);
        }
        for(int i = 0 ; i< m; i++){
            int q = input.nextInt();
            if(q == 1){
                int v = input.nextInt();
                add(v);
            }
            else if(q == 2){
                remove();
            }
            else {
                System.out.println(find());
            }

        }
    }
}
