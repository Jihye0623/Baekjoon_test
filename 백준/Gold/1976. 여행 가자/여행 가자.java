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
        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());
        
        parent = new int[n+1];
        for(int i = 0; i<=n; i++){
            parent[i] = i;
        }
        
        StringTokenizer st;
        for(int i = 1; i<=n; i++){     
            st = new StringTokenizer(br.readLine());   
            for(int j = 1; j<=n; j++){
                if(Integer.parseInt(st.nextToken())==1)
                    union(i,j);
            }
        }
        
        st = new StringTokenizer(br.readLine());  
        int[] city = new int[m+1];
        for(int i = 0; i<m; i++){      
            city[i] = Integer.parseInt(st.nextToken());
        }
        
        boolean flag = true;
        for(int i = 0; i<m-1; i++){
            if(find(city[i]) != find(city[i+1])){
                flag = false;
                break;
            }
        }
        
        if(flag) System.out.println("YES");
        else System.out.println("NO");
    }
}