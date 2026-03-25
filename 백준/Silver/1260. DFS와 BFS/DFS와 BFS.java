import java.util.*;
import java.io.*;

class Main{
    private static ArrayList<Integer>[] adjList;
    private static boolean[] visited;
    private static StringBuilder sb = new StringBuilder();

    private static void dfs(int now){
        visited[now] = true;
        sb.append(now).append(" ");

        for(int next:adjList[now]){
            if(!visited[next]){
                visited[next] = true;
                dfs(next);
            }
        }
        
    }
    
    private static void bfs(int start){
        visited[start] = true;
        ArrayDeque<Integer> queue = new ArrayDeque<>();
        queue.addLast(start);
        
        while(!queue.isEmpty()){
            int now = queue.pollFirst();
            sb.append(now).append(" ");
            
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
        
        StringTokenizer st = new StringTokenizer(br.readLine());    
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int v = Integer.parseInt(st.nextToken());
        
        adjList = new ArrayList[n+1];
        visited = new boolean[n+1];
        
        for(int i = 1; i<n+1; i++){
            adjList[i] = new ArrayList<>();
        }
        
        for(int i = 0; i<m; i++){
            st = new StringTokenizer(br.readLine());    
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            
            adjList[a].add(b);
            adjList[b].add(a);
        }
        
        for(int i = 1; i<n+1; i++){
           Collections.sort(adjList[i]);
        }
                
        dfs(v);
        sb.append("\n");
        visited = new boolean[n+1];
        bfs(v);
	
        System.out.println(sb);
    }
}