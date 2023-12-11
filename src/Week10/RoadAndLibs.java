package Week10;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class RoadAndLibs {
    private static class ConnectedComponent{
        List<List<Integer>> adj = new ArrayList<>();
        long cnt = 0;
        boolean[] visited;
        long[] amount;
        long[] id;
        long count = 1;

        public ConnectedComponent(List<List<Integer>> adj,int n) {
            amount = new long[9999999];
            id = new long[9999999];
            visited = new boolean[9999999];
            this.adj = adj;
            for(int i = 1; i < n+1; i++){
                cnt = 1;
                if(!visited[i]){
                    dfs(i,adj);
                    amount[(int)count] = cnt;
                    count++;
                }
            }
        }

        private void dfs(int i, List<List<Integer>> adj) {
            visited[i] = true;
            id[i] = count;
            for(int w : adj.get(i)){
                if(!visited[w]){
                    cnt++;
                    dfs(w,adj);
                }
            }
        }
    }
    public static void main(String[] args){

        Scanner input = new Scanner(System.in);
        int q = input.nextInt();
        for(int i = 0; i < q; i++){
            List<List<Integer>> adj = new ArrayList<>();
            long n = input.nextLong();
            long m = input.nextLong();
            int c_lib = input.nextInt();
            int c_road = input.nextInt();
            if(m == 0){
                System.out.println(n*c_lib);
                continue;
            }
            for(int k = 0; k <= n; k++){
                List<Integer> tmp = new ArrayList<>();
                adj.add(tmp);
            }

            for(int j = 0; j < m; j++){
                int v = input.nextInt();
                int w = input.nextInt();
                adj.get(v).add(w);
                adj.get(w).add(v);
            }
            ConnectedComponent cc = new ConnectedComponent(adj,(int)n);
            long cost = 0;
            for(int tmp = 1; tmp<cc.count; tmp++){
                cost+=(cc.amount[tmp]-1)*c_road+c_lib;
            }
            if((long) n *c_lib>cost){
                System.out.println(cost);
            } else{
                System.out.println(n*c_lib);
            }
        }

    }
}
