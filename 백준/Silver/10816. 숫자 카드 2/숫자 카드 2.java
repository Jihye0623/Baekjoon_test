import java.util.*;
import java.io.*;

class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i<n; i++){
            int k = Integer.parseInt(st.nextToken());
            map.put(k, map.getOrDefault(k, 0)+1);
        }
        
		StringBuilder sb = new StringBuilder();
        int m = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        
        for(int i = 0; i<m; i++){
            int k = Integer.parseInt(st.nextToken());
            sb.append(map.getOrDefault(k, 0)).append(" ");
        }
        
        System.out.println(sb);
    }
}