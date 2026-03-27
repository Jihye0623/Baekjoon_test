import java.util.*;
import java.io.*;

class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        
        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        for(int t = 0; t<T; t++){
            int n = Integer.parseInt(br.readLine());
            st = new StringTokenizer(br.readLine());
            int[] team = new int[n+1];
            for(int i = 1; i<n+1; i++){
                team[i] = Integer.parseInt(st.nextToken());
            }
            
            boolean[][] graph = new boolean[n+1][n+1];
            int[] inDegree = new int[n+1];
            for(int i = 1; i<n+1; i++){
                for(int j=i+1; j<n+1; j++){
                    graph[team[i]][team[j]] = true;
                    inDegree[team[j]]++;
                }
            }
            
            int m = Integer.parseInt(br.readLine());
            for(int i = 0; i<m; i++){            
                st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                
                if(graph[a][b]){
                    graph[a][b] = false;
                    graph[b][a] = true;
                    inDegree[b]--;
                    inDegree[a]++;
                }
                else{
                    graph[b][a] = false;
                    graph[a][b] = true;
                    inDegree[a]--;
                    inDegree[b]++;
                }
            }
            
            
            Queue<Integer> queue = new ArrayDeque<>();
            for(int i = 1; i<=n; i++){
                if(inDegree[i] == 0) queue.add(i);
            }
        
            ArrayList<Integer> result = new ArrayList<>();
            boolean isAmbi = false;
            
            for(int i = 0; i<n; i++){
                if(queue.isEmpty()) break;
                if(queue.size()>1){
                    isAmbi = true;
                    break;
                }
                
                int current = queue.poll();
                result.add(current);
                
                for(int next=1; next<=n; next++){
                    if(graph[current][next]){
                        inDegree[next]--;
                        if(inDegree[next]==0) queue.add(next);
                    }
                }
            }

            if(isAmbi){
                sb.append("?\n");
            }
            else if(result.size()!=n){
                sb.append("IMPOSSIBLE\n");
            }
            else{
                for(int r:result){
                    sb.append(r).append(" ");
                }
                sb.append("\n");
            }
        }
        
        
        System.out.println(sb);
    }
}