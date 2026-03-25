import java.util.*;
import java.io.*;

class Main{
    
    private static ArrayList<Integer>[] adjList;
    private static int[] visited;
    private static int cnt = 1;
    

    private static void bfs(int start){
        visited[start] = cnt++;
        ArrayDeque<Integer> queue = new ArrayDeque<>();
        queue.addLast(start);

        while(!queue.isEmpty()){
            int now = queue.pollFirst();

            for(int next:adjList[now]){
                if(visited[next] == 0) {
                    visited[next] = cnt++;
                    queue.addLast(next);
                }
            }
        }
        
        
    }
    
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
		
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int R = Integer.parseInt(st.nextToken());
        
        adjList = new ArrayList[N+1];
        visited = new int[N+1];
        
        for(int i = 1; i<N+1; i++){
            adjList[i] = new ArrayList<>();
        }
        
        for(int i = 0; i<M; i++){
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            adjList[u].add(v);
            adjList[v].add(u);
        }

        for(int i = 1; i<N+1; i++){
            Collections.sort(adjList[i], Collections.reverseOrder());
        }
        
        bfs(R);
        
        StringBuilder sb = new StringBuilder();
        for(int i = 1; i<N+1; i++) sb.append(visited[i]).append("\n");
        System.out.println(sb);
        
    }
}