import java.util.*;
import java.io.*;

class Main{
    private static int N, E;
    private static ArrayList<ArrayList<Node>> graph;
    private static class Node{
        int num,cost;
        public Node(int num, int cost){
            this.num = num;
            this.cost = cost;
        }
    }
    
    private static int[] dijkstra(int start){
        int[] dist = new int[N+1];
        for(int i = 1; i<=N; i++) dist[i] = 200000000;
        dist[start] = 0;
        
        PriorityQueue<Node> queue = new PriorityQueue<>((o1,o2)->Integer.compare(o1.cost, o2.cost));
        queue.add(new Node(start,0));
        
        while(!queue.isEmpty()){
            Node now = queue.poll();
            if(now.cost > dist[now.num]) continue;
            
            for(Node next : graph.get(now.num)){
                if(dist[next.num]>now.cost + next.cost){
                    dist[next.num] = now.cost + next.cost;
                    queue.add(new Node(next.num, dist[next.num]));
                }
            }
        }
        
        return dist;
    }
    
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());    
		E = Integer.parseInt(st.nextToken());    
        
        graph = new ArrayList<>();
        for(int i = 0; i<=N; i++){
            graph.add(new ArrayList<>());
        }
        
        for(int i = 0; i<E; i++){
            st = new StringTokenizer(br.readLine());
		    int a = Integer.parseInt(st.nextToken());    
		    int b = Integer.parseInt(st.nextToken());   
		    int c = Integer.parseInt(st.nextToken()); 
            graph.get(a).add(new Node(b,c));
            graph.get(b).add(new Node(a,c));
        }
        st = new StringTokenizer(br.readLine());
		int v1 = Integer.parseInt(st.nextToken());    
		int v2 = Integer.parseInt(st.nextToken());  
        
        int[] distFrom1 = dijkstra(1);
        int[] distFromV1 = dijkstra(v1);
        int[] distFromV2 = dijkstra(v2);
        
        int path1 = distFrom1[v1] + distFromV1[v2] + distFromV2[N];
        int path2 = distFrom1[v2] + distFromV2[v1] + distFromV1[N];
        int answer = Math.min(path1, path2);
        
        if(answer>=200000000) System.out.println(-1);
        else System.out.println(answer);
        
    }
}