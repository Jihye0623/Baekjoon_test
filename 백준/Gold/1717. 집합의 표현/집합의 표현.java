import java.util.*;
import java.io.*;

class Main{
    private static int[] parent;
    private static int find(int a){
        if(a==parent[a]) return a;
        else return parent[a] = find(parent[a]);
    }
    
    private static void union(int a, int b){
        int parentA = find(a);
        int parentB = find(b);
        parent[parentA] = parentB;
    }
    
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
        parent = new int[n+1];
        
        for(int i = 1; i<=n; i++){
            parent[i] = i;
        }
        
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i<m; i++){
            st = new StringTokenizer(br.readLine());
		    int op = Integer.parseInt(st.nextToken());
		    int a = Integer.parseInt(st.nextToken());
		    int b = Integer.parseInt(st.nextToken());
            if(op==0){
                union(a,b);
            } 
            else{
                if(find(a)!=find(b)) sb.append("NO");
                else sb.append("YES");
                sb.append("\n");
            }
        }
        
        System.out.println(sb);
        
    }
}