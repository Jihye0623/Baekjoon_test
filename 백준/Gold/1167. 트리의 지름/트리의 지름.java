import java.io.*;
import java.util.*;

class Main{
    private static ArrayList<ArrayList<Node>> graph;
    private static int result = 0, depart = 1;
    private static boolean[] visited;
    
    private static class Node{
        int n, cost;
        
        public Node(int n, int cost){
            this.n = n;
            this.cost = cost;
        }
    }
    
    private static void dfs(int now, int sum){
        visited[now] = true;
        if(sum>result){
            result = sum;
            depart = now;
        }
        
        for(Node next:graph.get(now)){
            if(!visited[next.n]){
                dfs(next.n, next.cost + sum);
            }
        }
    }
    
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        
        graph = new ArrayList<>();
        for(int i = 0; i<=n; i++){
            graph.add(new ArrayList<>());
        }
        
        for(int i = 0; i<n; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int num = Integer.parseInt(st.nextToken());
            
            while(true){
                int node = Integer.parseInt(st.nextToken());
                if(node == -1) break;
                
                int cost = Integer.parseInt(st.nextToken());
                graph.get(num).add(new Node(node, cost));
            }
        }
        
        visited = new boolean[n+1];
        dfs(1,0);
        
        visited = new boolean[n+1];
        dfs(depart,0);
        
        System.out.println(result);
        
    }
}