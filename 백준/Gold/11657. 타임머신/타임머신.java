import java.util.*;
import java.io.*;

class Main{
    static class Edge{
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
        
        ArrayList<Edge> edges = new ArrayList<>();
        for(int i = 0; i<m; i++){
            st = new StringTokenizer(br.readLine());
	    	int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            edges.add(new Edge(a,b,c));
        }
        
        long[] dist = new long[n+1];
        Arrays.fill(dist, Long.MAX_VALUE);
        dist[1] = 0;
        
        for(int i = 1; i<n; i++){
            for(Edge edge:edges){
                if(dist[edge.from]!= Long.MAX_VALUE && dist[edge.to] > dist[edge.from] + edge.cost){
                    dist[edge.to] = dist[edge.from] + edge.cost;
                }
            }
        }
        
        boolean hasNegativeCycle = false;
        for(Edge edge:edges){
            if(dist[edge.from] != Long.MAX_VALUE && dist[edge.to] > dist[edge.from] + edge.cost){
                hasNegativeCycle = true;
                break;
            }
        }
        
        if(hasNegativeCycle) System.out.println(-1);
        else{    
            StringBuilder sb = new StringBuilder();   
            for(int i = 2; i<=n; i++){
                if(dist[i] == Long.MAX_VALUE){
                    sb.append("-1\n");
                }
                else{
                    sb.append(dist[i]).append("\n");
                }
            }
            
            System.out.println(sb);
        }
    }
}