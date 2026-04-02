import java.util.*;
import java.io.*;

class Main{
    private static ArrayList<ArrayList<Integer>> graph;
    private static boolean[] visited;
    
    private static boolean bfs(int start){
        int link = 0, node = 0;
        ArrayDeque<Integer> queue = new ArrayDeque<>();
        queue.addLast(start);
        visited[start] = true;

        while(!queue.isEmpty()){
            node++;
            int now = queue.pollFirst();

            for(int next:graph.get(now)){
                link++;
                if(!visited[next]){
                    visited[next] = true;
                    queue.addLast(next);
                }
            }
        }

        return (link/2) == (node-1);
        
    }
    
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        int caseNum = 1;
        
        while(true){
            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());
          
            if(n==0 && m==0) break;
            
            graph = new ArrayList<>();
            for(int i = 0; i<=n; i++){
                graph.add(new ArrayList<>());
            }
            
            visited = new boolean[n+1];
            
            
            for(int i = 0; i<m; i++){
                st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                
                graph.get(a).add(b);
                graph.get(b).add(a);
            }
            
            int treeNum = 0;
            for(int i = 1; i<=n; i++){
                if(!visited[i]){
                    if(bfs(i)){
                        treeNum++;
                    }
                }
            }
            
            sb.append("Case " + caseNum +": ");
            if(treeNum==0) sb.append("No trees.\n");
            else if(treeNum==1) sb.append("There is one tree.\n");
            else sb.append("A forest of " + treeNum +" trees.\n");
            
            caseNum++;
        }
        
        System.out.println(sb);
        
    }
}