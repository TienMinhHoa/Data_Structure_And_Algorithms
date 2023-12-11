package Week11;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Scanner;

public class DijktraAlgo {
    private static class edge implements Comparable{
        int v;
        int w;
        public int weight;

        public edge(int v, int w, int weight) {
            this.v = v;
            this.w = w;
            this.weight = weight;
        }

        /**
         * Compares this object with the specified object for order.  Returns a
         * negative integer, zero, or a positive integer as this object is less
         * than, equal to, or greater than the specified object.
         *
         * <p>The implementor must ensure {@link Integer#signum
         * signum}{@code (x.compareTo(y)) == -signum(y.compareTo(x))} for
         * all {@code x} and {@code y}.  (This implies that {@code
         * x.compareTo(y)} must throw an exception if and only if {@code
         * y.compareTo(x)} throws an exception.)
         *
         * <p>The implementor must also ensure that the relation is transitive:
         * {@code (x.compareTo(y) > 0 && y.compareTo(z) > 0)} implies
         * {@code x.compareTo(z) > 0}.
         *
         * <p>Finally, the implementor must ensure that {@code
         * x.compareTo(y)==0} implies that {@code signum(x.compareTo(z))
         * == signum(y.compareTo(z))}, for all {@code z}.
         *
         * @param o the object to be compared.
         * @return a negative integer, zero, or a positive integer as this object
         * is less than, equal to, or greater than the specified object.
         * @throws NullPointerException if the specified object is null
         * @throws ClassCastException   if the specified object's type prevents it
         *                              from being compared to this object.
         * @apiNote It is strongly recommended, but <i>not</i> strictly required that
         * {@code (x.compareTo(y)==0) == (x.equals(y))}.  Generally speaking, any
         * class that implements the {@code Comparable} interface and violates
         * this condition should clearly indicate this fact.  The recommended
         * language is "Note: this class has a natural ordering that is
         * inconsistent with equals."
         */
        @Override
        public int compareTo(Object o) {
            edge e = (edge) o;
            return this.weight - e.weight;
        }
        public int other(int v){
            if(v == this.v){
                return w;
            }
            return v;
        }
        public int either(){
            return v;
        }
    }
    private static class traject implements Comparable{
        public int v;
        public int dist;

        public traject(int v, int dist) {
            this.v = v;
            this.dist = dist;
        }

        /**
         * Compares this object with the specified object for order.  Returns a
         * negative integer, zero, or a positive integer as this object is less
         * than, equal to, or greater than the specified object.
         *
         * <p>The implementor must ensure {@link Integer#signum
         * signum}{@code (x.compareTo(y)) == -signum(y.compareTo(x))} for
         * all {@code x} and {@code y}.  (This implies that {@code
         * x.compareTo(y)} must throw an exception if and only if {@code
         * y.compareTo(x)} throws an exception.)
         *
         * <p>The implementor must also ensure that the relation is transitive:
         * {@code (x.compareTo(y) > 0 && y.compareTo(z) > 0)} implies
         * {@code x.compareTo(z) > 0}.
         *
         * <p>Finally, the implementor must ensure that {@code
         * x.compareTo(y)==0} implies that {@code signum(x.compareTo(z))
         * == signum(y.compareTo(z))}, for all {@code z}.
         *
         * @param o the object to be compared.
         * @return a negative integer, zero, or a positive integer as this object
         * is less than, equal to, or greater than the specified object.
         * @throws NullPointerException if the specified object is null
         * @throws ClassCastException   if the specified object's type prevents it
         *                              from being compared to this object.
         * @apiNote It is strongly recommended, but <i>not</i> strictly required that
         * {@code (x.compareTo(y)==0) == (x.equals(y))}.  Generally speaking, any
         * class that implements the {@code Comparable} interface and violates
         * this condition should clearly indicate this fact.  The recommended
         * language is "Note: this class has a natural ordering that is
         * inconsistent with equals."
         */
        @Override
        public int compareTo(Object o) {
            traject t = (traject) o;
            return this.dist  - t.dist;
        }
    }
    public static PriorityQueue<traject> q = new PriorityQueue<>();
    public static traject[] index = new traject[999999];
//    public static List<List<edge>> adj = new ArrayList<>();

    public static int[] distTo = new int[999999];
    public static edge[] edgeTo = new edge[999999];


    public static boolean[] mark = new boolean[999999];

    public  static void relax(edge a){
        int v = a.v;
        int w = a.w;
        if(distTo[w]>distTo[v] + a.weight){
//            index[w] = new traject(w,distTo[w]);
            distTo[w] = distTo[v]+a.weight;
            edgeTo[w] = a;
            if(mark[w]){
                q.remove(index[w]);
                index[w].dist = distTo[w];
               q.offer(index[w]);
            } else{
                index[w] = new traject(w,distTo[w]);
                q.offer(index[w]);
                mark[w] = true;
            }
        }
    }
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int querry = input.nextInt();
        for (int i = 0; i < querry; i++) {
            List<List<edge>> adj = new ArrayList<>();
            int n = input.nextInt();
            for(int k = 0; k < n+1; k++){
                List<edge> tmp = new ArrayList<>();
                adj.add(tmp);
            }
            int m = input.nextInt();
            for(int j = 0; j < m; j++){
                int v = input.nextInt();
                int w = input.nextInt();
                int weight = input.nextInt();
                edge e1 = new edge(v,w,weight);
                edge e2 = new edge(w,v,weight);
                adj.get(v).add(e1);
                adj.get(w).add(e2);
            }
            for(int j = 0; j < n+1; j++){
                distTo[j] = 99999999;
                mark[j] = false;
            }
            int start = input.nextInt();
            index[start] = new traject(start,0);
            distTo[start] = 0;
            q.add(index[start]);
            while(!q.isEmpty()){
                int v = q.poll().v;
                for(edge e: adj.get(v)){
                    relax(e);
                }
            }
            for(int j = 1; j <= n; j++){
                if(j!=start)
                    if(distTo[j]<99999999)
                        System.out.print(distTo[j]+" ");
                    else
                        System.out.print(-1+" ");
            }
            System.out.println();
        }
    }
}
