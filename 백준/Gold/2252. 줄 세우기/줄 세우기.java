import java.util.*;
import java.io.*;

class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        
        
        ArrayList<ArrayList<Integer>> graph = new ArrayList<ArrayList<Integer>>();
        for(int i = 0; i<=n; i++){
            graph.add(new ArrayList<Integer>());
        }
        int[] inDegree = new int[n+1];
        
        for(int i = 0 ; i<m; i++){
            st = new StringTokenizer(br.readLine());
	    	int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            graph.get(a).add(b);
            inDegree[b]++;           
        }
        
        ArrayDeque<Integer> queue = new ArrayDeque<>();
        for(int i = 1; i<=n; i++){
            if(inDegree[i] == 0) queue.add(i);
        }
        
        StringBuilder sb = new StringBuilder();
        
        while(!queue.isEmpty()){
            int current = queue.pollFirst();
            sb.append(current).append(" ");
            
            for(int next:graph.get(current)){
                inDegree[next]--;
                if(inDegree[next]==0) queue.add(next);
            }
        }
        
        System.out.println(sb);
    }
}