import java.util.*;
import java.io.*;

class Main{
    private static ArrayList<Integer>[] adjList;
    private static int[] visited;
    private static int count = 1;
    private static void dfs(int start){
        visited[start] = count++;
        
        for(int i = 0; i<adjList[start].size(); i++){
            int next = adjList[start].get(i);
            if(visited[next]==0){
                dfs(next);
            }
        }
    }
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());    
		int m = Integer.parseInt(st.nextToken());    
		int k = Integer.parseInt(st.nextToken());  
        
        adjList = new ArrayList[n+1];
        visited = new int[n+1];
        
        for(int i = 0; i<n+1; i++){
            adjList[i] = new ArrayList<>();
        }
        
        for(int i = 0; i<m; i++){
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            adjList[u].add(v);
            adjList[v].add(u);
        }
        
         for(int i = 0; i<n+1; i++){
            Collections.sort(adjList[i]);
        }
        
        dfs(k);
        
        StringBuilder sb = new StringBuilder();
        
        for(int i = 1; i<=n; i++) sb.append(visited[i]).append("\n");
        System.out.println(sb);
        
        
    }
}