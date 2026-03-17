import java.util.*;
import java.io.*;

class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        
        int[] arr = new int[n+1];
        int[] dp = new int[n+1];
        st = new StringTokenizer(br.readLine());
        for(int i = 1; i<=n; i++){
            arr[i] = Integer.parseInt(st.nextToken());
            dp[i] = dp[i-1] + arr[i];
        }
        
        
        StringBuilder sb = new StringBuilder();
        
        for(int k = 0; k<m; k++){
            st = new StringTokenizer(br.readLine()); 
            int i = Integer.parseInt(st.nextToken());    
            int j = Integer.parseInt(st.nextToken()); 
            
            int temp = dp[j] - dp[i-1];
            sb.append(temp).append("\n");
        }
        
        System.out.println(sb);
    }
}