package Week11;


import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Scanner;

public class KrusKalAlgo  {
    private static class Edge implements  Comparable{
        public int v;
        public int w;
        public int weight;

        public Edge(int v, int w, int weight) {
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
            Edge e = (Edge) o;
            return this.weight - e.weight;
        }
        public int either(){
            return v;
        }
        public int other(int v){
            if(this.v != v){
                return this.v;
            }
            return this.w;
        }
    }

    public static PriorityQueue<Edge> q = new PriorityQueue<>();

    private static class UF{
        int[] root = new int[9999999];
        public UF(int n){
            for(int i = 0; i <= n; i++){
                root[i] = -1;
            }
        }
        public int getRoot(int a){
            while(root[a]>0){
                a = root[a];
            }
            return a;
        }
        public boolean isConnected(int a, int b){
            return getRoot(a) == getRoot(b);
        }
        public void connect(int a, int b){
            if(isConnected(a,b)){
                return;
            }
            int ra = getRoot(a);
            int rb = getRoot(b);
            if(root[ra] > root[rb]){
                int tmp = root[ra];
                root[ra] = rb;
                root[rb]+=tmp;
            } else{
                int tmp = root[rb];
                root[rb] = ra;
                root[ra]+=tmp;
            }
        }
    }

    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        int g_nodes = input.nextInt();
        int g_edges = input.nextInt();
        for(int i = 0; i < g_edges; i++){
            int g_from = input.nextInt();
            int g_to = input.nextInt();
            int g_weight = input.nextInt();
            Edge tmp = new Edge(g_from,g_to,g_weight);
            q.add(tmp);
        }
        UF uf = new UF(g_nodes);
        int cnt = 0;
        int sum = 0;
        while(!q.isEmpty()&&cnt<g_nodes-1){
            Edge e = q.poll();
            int v = e.v;
            int w = e.w;
            int weight = e.weight;
            if(!uf.isConnected(v,w)){
                uf.connect(v,w);
                sum+=weight;
                cnt++;
            }
        }
        System.out.println(sum);
    }
}
