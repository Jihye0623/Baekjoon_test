import java.util.*;
import java.io.*;

class Main{
    static class Node implements Comparable<Node>{
        int to, cost;
        
        public Node(int to, int cost){
            this.to = to;
            this.cost = cost;
        }
        
        @Override
        public int compareTo(Node o) {
            return Integer.compare(this.cost, o.cost);
        }
    }
    
    static int n,m,t,s,g,h;
    static ArrayList<ArrayList<Node>> graph;
    static final int INF = 50000000;
    
    static int[] dijkstra(int start){
        int[] dist = new int[n+1];
        Arrays.fill(dist, INF);
        dist[start] = 0;
        
        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.add(new Node(start,0));
        
        while(!pq.isEmpty()){
            Node now = pq.poll();
            
            if(now.cost > dist[now.to]) continue;
            
            for(Node next:graph.get(now.to)){
                if(dist[next.to]>dist[now.to]+next.cost){
                    dist[next.to] = dist[now.to]+next.cost;
                    pq.add(new Node(next.to, dist[next.to]));
                }
            }
        }
        
        return dist;
        
    }
    
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        
        for(int tc = 0; tc<T; tc++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            n = Integer.parseInt(st.nextToken());
            m = Integer.parseInt(st.nextToken());
            t = Integer.parseInt(st.nextToken());
            
            st = new StringTokenizer(br.readLine());
            s = Integer.parseInt(st.nextToken());
            g = Integer.parseInt(st.nextToken());
            h = Integer.parseInt(st.nextToken());
            
            graph = new ArrayList<>();
            for(int i = 0; i<=n; i++){
                graph.add(new ArrayList<>());
            }
            
            for(int i = 0; i<m; i++){
                st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                int d = Integer.parseInt(st.nextToken());
                
                graph.get(a).add(new Node(b,d));
                graph.get(b).add(new Node(a,d));
            }
            
            ArrayList<Integer> candidates = new ArrayList<>();
            for(int i = 0; i<t; i++) candidates.add(Integer.parseInt(br.readLine()));
            
            int[] distS = dijkstra(s);
            int[] distG = dijkstra(g);
            int[] distH = dijkstra(h);
            
            Collections.sort(candidates);
            
            int ghDist = distG[h];
            
            for(int dest:candidates){
                long path1 = (long) distS[g] + ghDist + distH[dest];
                long path2 = (long) distS[h] + ghDist + distG[dest];
               
                if(distS[dest] != INF && (distS[dest] == path1 || distS[dest] == path2)){
                    sb.append(dest).append(" ");
                }
            }
            
            sb.append("\n");
        }
        System.out.println(sb);
    }
}