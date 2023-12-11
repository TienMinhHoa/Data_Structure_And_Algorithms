package Week10;

import edu.princeton.cs.algs4.Bag;

public class GraphAPI {
    private final int V;
    private Bag<Integer>[] adj;

    public GraphAPI(int v) {
        V = v;
        adj = (Bag<Integer>[]) new Bag[V];
        for(int i = 0; i < V; i++){
            adj[i] = new Bag<Integer>();
        }
    }
    public void addEdge(int v, int w){
        adj[v].add(w);
        adj[w].add(v);
    }
    public Iterable<Integer> adj(int v){
        return adj[v];
    }
}
