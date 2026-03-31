import java.util.*;
import java.io.*;

class Main{
    private static class Node{
        int idx, cost;
        public Node(int idx, int cost){
            this.idx = idx;
            this.cost = cost;
        }
    }
    
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
		
        int v = Integer.parseInt(st.nextToken());
        int e = Integer.parseInt(st.nextToken());
        
        int k = Integer.parseInt(br.readLine());
        
        ArrayList<ArrayList<Node>> graph = new ArrayList<>();
        for(int i = 0; i<=v; i++){
            graph.add(new ArrayList<>());
        }
        
        for(int i = 0; i<e; i++){
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v1 = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            
            graph.get(u).add(new Node(v1,w));
        }
        
        StringBuilder sb = new StringBuilder();
        PriorityQueue<Node> queue = new PriorityQueue<>((o1,o2)-> Integer.compare(o1.cost, o2.cost));
        queue.add(new Node(k,0));
        
        int[] dist = new int[v+1];
        for(int i = 0; i<=v; i++){
            dist[i] = Integer.MAX_VALUE;
        }
        dist[k] = 0;
        
        while(!queue.isEmpty()){
            Node now = queue.poll();
            if(now.cost > dist[now.idx]) continue;
            
            for(Node next:graph.get(now.idx)){
                if(dist[next.idx] > now.cost + next.cost){
                    dist[next.idx] = now.cost + next.cost;
                    queue.add(new Node(next.idx, dist[next.idx]));
                }
            }
        }
        
        for(int i = 1; i<=v; i++){
            if(dist[i]>=Integer.MAX_VALUE) sb.append("INF").append("\n");
            else sb.append(dist[i]).append("\n");
        }
        System.out.println(sb);
        
    }
}