import java.io.*;
import java.util.*;

class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        
        ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
        for(int i = 0; i<=n; i++){
            graph.add(new ArrayList<>());
        }
        
        for(int i = 0; i<n-1; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            
            graph.get(a).add(b);
            graph.get(b).add(a);
        }
        
        int[] parent = new int[n+1];
        parent[1] = 1;
        
        ArrayDeque<Integer> queue = new ArrayDeque<>();
        queue.add(1);
        
        while(!queue.isEmpty()){
            int now = queue.pollFirst();
            
            for(int next:graph.get(now)){
                if(parent[next]==0){
                    parent[next] = now;
                    queue.add(next);
                }
            }
        }
        
        
        StringBuilder sb = new StringBuilder();
        for(int i = 2; i<=n; i++) sb.append(parent[i]).append("\n");
        System.out.println(sb);       
        
    }
}