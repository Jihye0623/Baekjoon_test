import java.io.*;
import java.util.*;

class Main{
    private static int result = 0, depart = 1;
    private static boolean[] visited;
    private static ArrayList<ArrayList<Node>> graph;
    
    public static class Node{
        int num, cost;
        
        public Node(int num, int cost){
            this.num = num;
            this.cost = cost;
        }
    }
    
    private static void dfs(int now, int sum){
        visited[now] = true;
        if(result < sum){
            result = sum;
            depart = now;
        }
        
        for(Node next:graph.get(now)){
            if(!visited[next.num]){
                dfs(next.num, sum + next.cost);
            }
        }
    }
    
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int v = Integer.parseInt(br.readLine());
        
        graph = new ArrayList<>();
        for(int i = 0; i<=v; i++){
            graph.add(new ArrayList<>());
        }
        
        for(int i = 0; i<v; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            
            int num = Integer.parseInt(st.nextToken());
            
            while(true){
                int k = Integer.parseInt(st.nextToken());
                if(k==-1) break;
                
                int cost = Integer.parseInt(st.nextToken());
                graph.get(num).add(new Node(k, cost));
            }
        }
        
        visited = new boolean[v+1];
        dfs(1,0);
        
        visited = new boolean[v+1];
        dfs(depart,0);
        
        System.out.println(result);
        
        
    }
}