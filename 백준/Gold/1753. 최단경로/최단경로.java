import java.util.*;
import java.io.*;

class Main{
    public static class Node{
        int num, cost;
        public Node(int num, int cost){
            this.num = num;
            this.cost = cost;
        }
    }
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
		int V = Integer.parseInt(st.nextToken());
        int E = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(br.readLine());
        
        ArrayList<ArrayList<Node>> graph = new ArrayList<>();
        for(int i = 0; i<V+1; i++){
            graph.add(new ArrayList<>()); 
        }
        
        for(int i = 0; i<E; i++){
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            graph.get(u).add(new Node(v,w));
        }
        
        StringBuilder sb = new StringBuilder();
        PriorityQueue<Node> queue = new PriorityQueue<>((o1,o2)->Integer.compare(o1.cost, o2.cost));
        queue.add(new Node(K,0));
        
        int[] dist = new int[V+1];
        for(int i = 1; i<V+1; i++){
            dist[i] = Integer.MAX_VALUE;
        }
        dist[K] = 0;
        
        while(!queue.isEmpty()){
            Node now = queue.poll();
            if (now.cost>dist[now.num]) continue;
            
            for(Node next:graph.get(now.num)){
                if(dist[next.num]>now.cost + next.cost){
                    dist[next.num] = now.cost+next.cost;
                    queue.add(new Node(next.num, dist[next.num]));
                }
            }
        }
        
        for(int i = 1; i<=V; i++){
            if(dist[i]>=Integer.MAX_VALUE) sb.append("INF").append("\n");
            else sb.append(dist[i]).append("\n");
        }
        
        System.out.println(sb);
        
    }
}