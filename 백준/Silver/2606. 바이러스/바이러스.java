import java.util.*;
import java.io.*;

class Main{
    private static ArrayList<Integer>[] adjList;
    private static boolean[] visited;
    
    private static void bfs(int start){
        visited[start] = true;
        ArrayDeque<Integer> queue = new ArrayDeque<>();
        queue.addLast(start);
        
        while(!queue.isEmpty()){
            int now = queue.pollFirst();
            
            for(int next:adjList[now]){
                if(!visited[next]){
                    visited[next] = true;
                    queue.addLast(next);
                }
            }
        }
    }
    
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());
        
        adjList = new ArrayList[n+1];
        visited = new boolean[n+1];
        
        for(int i = 1; i<n+1; i++){
            adjList[i] = new ArrayList<>();
        }
        
        for(int i = 0; i<m; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());    
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            
            adjList[u].add(v);
            adjList[v].add(u);
        }
                
        bfs(1);
        
        int cnt = 0;
        for(int i = 1; i<n+1; i++){
            if(visited[i]) cnt++;
        }
	
        System.out.println(cnt-1);
    }
}