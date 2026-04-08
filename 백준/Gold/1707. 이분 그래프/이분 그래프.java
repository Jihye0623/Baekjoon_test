import java.util.*;
import java.io.*;

class Main{
    static ArrayList<ArrayList<Integer>> graph;
    static int[] colors;
    static boolean isBipartite;
    
    static void bfs(int start){
        ArrayDeque<Integer> queue = new ArrayDeque<>();
        colors[start] = 1;
        queue.add(start);
        
        while(!queue.isEmpty() && isBipartite){
            int now = queue.poll();
            
            for(int next:graph.get(now)){
                if(colors[next]==0){
                    colors[next] = (colors[now] == 1) ? 2:1;
                    queue.add(next);
                }
                else if(colors[next] == colors[now]){
                    isBipartite = false;
                    return ; 
                }
            }
        }
    }
    
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int K = Integer.parseInt(br.readLine());
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        
        for(int k = 0; k<K; k++){
            st = new StringTokenizer(br.readLine());
            int v = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            
            graph = new ArrayList<>();
            for(int i = 0; i<=v; i++){
                graph.add(new ArrayList<>());
            }
            
            for(int i = 0; i<e; i++){
                st = new StringTokenizer(br.readLine());
                int U = Integer.parseInt(st.nextToken());
                int V = Integer.parseInt(st.nextToken());
                graph.get(U).add(V);
                graph.get(V).add(U);
            }
            
            colors = new int[v+1];
            isBipartite = true;
            
            
            for(int i = 1; i<=v; i++){
                if(!isBipartite) break;
                if(colors[i] == 0) bfs(i);
            }
            
            if(isBipartite) sb.append("YES\n");
            else sb.append("NO\n");
        }
        
        System.out.println(sb);
		    
       
    }
}