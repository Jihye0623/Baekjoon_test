import java.util.*;
import java.io.*;

class Main{
    private static class Edge{
        int from, to, cost;
        public Edge(int from, int to, int cost){
            this.from = from;
            this.to = to;
            this.cost = cost;
        }
    }
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        
        ArrayList<Edge> list = new ArrayList<>();
        for(int i = 0; i<m; i++){
            st = new StringTokenizer(br.readLine());
        
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            
            list.add(new Edge(a,b,c));
        }
        
        long[] dist = new long[n+1];
        Arrays.fill(dist, Long.MAX_VALUE);
        dist[1] = 0;
        
        for(int i=1; i<n; i++){
            for(Edge edge: list){
                if(dist[edge.from]!=Long.MAX_VALUE && dist[edge.to]>dist[edge.from]+edge.cost){
                    dist[edge.to] = dist[edge.from] + edge.cost;
                }
            }
        }
        
        boolean isMinus = false;
        for(int i=1; i<n; i++){
            for(Edge edge: list){
                if(dist[edge.from]!=Long.MAX_VALUE && dist[edge.to]>dist[edge.from]+edge.cost){
                    isMinus = true;
                    break;
                }
            }
        }
        
        if(isMinus) System.out.println(-1);
        else{
            StringBuilder sb = new StringBuilder();
            for(int i=2; i<=n; i++) {
                if(dist[i]!=Long.MAX_VALUE) sb.append(dist[i]).append("\n");
                else sb.append(-1).append("\n");
            }
            System.out.println(sb);
        }
        
    }
}