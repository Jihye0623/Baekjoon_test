import java.util.*;
import java.io.*;

class Main{
    private static int[] parent;
    private static int[] size;
    private static int find(int x){
        if(x==parent[x]) return x;
        return parent[x] = find(parent[x]);
    }
    
    private static int union(int a, int b){
        int pa = find(a);
        int pb = find(b);
        
        if(pa!=pb){
            parent[pa] = parent[pb];
            size[pb] += size[pa];
        }
        
        return size[pb];
    }
    
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        
        for(int t = 0; t<T; t++){
            int f = Integer.parseInt(br.readLine());
            parent = new int[f*2+1];
            size = new int[f*2+1];
            for(int i = 0; i<=f*2; i++){
                parent[i] = i;
                size[i] = 1;
            }
            
            HashMap<String, Integer> map = new HashMap<>();
            int num = 1;
            
            for(int i = 0; i<f; i++){
                st = new StringTokenizer(br.readLine());
                String s1 = st.nextToken();
                String s2 = st.nextToken();
                
                if(!map.containsKey(s1)) map.put(s1, num++);
                if(!map.containsKey(s2)) map.put(s2, num++);
                
                sb.append(union(map.get(s1), map.get(s2))).append("\n");
            }
        }
        
        System.out.println(sb);
    }
}