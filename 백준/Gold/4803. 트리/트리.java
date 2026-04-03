import java.util.*;
import java.io.*;

class Main{
    private static ArrayList<ArrayList<Integer>> graph;
    private static boolean[] visited;
    
    private static boolean isTree(int start){
        visited[start] = true;
        int node = 0, edge = 0;
        
        ArrayDeque<Integer> queue = new ArrayDeque<>();
        queue.add(start);
        
        while(!queue.isEmpty()){
            int now = queue.poll();
            node++;
            for(int next:graph.get(now)){
                edge++;
                if(!visited[next]){
                    visited[next] = true;
                    queue.add(next);
                }
            }
        }
       
        return (edge/2)==(node-1);
    }
    
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        int caseNum = 1;
        
        while(true){
            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());
            
            if(n==0 && m==0) break;
            
            graph = new ArrayList<>();
            for(int i = 0; i<=n; i++) graph.add(new ArrayList<>());
            
            for(int i = 0; i<m; i++){
                st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                
                graph.get(a).add(b);
                graph.get(b).add(a);
            }
            
            visited = new boolean[n+1];
            int treeCount = 0;
            
            for(int i = 1; i<=n; i++){
                if(!visited[i]){
                    if(isTree(i)){
                        treeCount++;
                    }
                }
            }

            sb.append("Case " + caseNum +": ");
            
            if(treeCount==0) sb.append("No trees.\n");
            else if(treeCount==1) sb.append("There is one tree.\n");
            else sb.append("A forest of " + treeCount + " trees.\n");

            caseNum++;
        }
        
        System.out.println(sb);
    }
}