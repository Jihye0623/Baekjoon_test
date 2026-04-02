import java.util.*;
import java.io.*;

class Main{
    private static int[] parent;
    
    private static int find(int x){
        if(x==parent[x]) return x;
        else return parent[x] = find(parent[x]);
    }
    
    private static void union(int a, int b){
        int pa = find(a);
        int pb = find(b);
        
        parent[pa] = pb;
    }
    
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
		
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        
        parent = new int[n+1];
        for(int i = 0; i<=n; i++){
            parent[i] = i;
        }
        
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i<m; i++){
            st = new StringTokenizer(br.readLine());
		
            int op = Integer.parseInt(st.nextToken());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            
            if(op==0) union(a,b);
            else{
                if(find(a)!=find(b)) sb.append("NO\n");
                else sb.append("YES\n");
            }
        
        }
        
        System.out.println(sb);
        
        
    }
}