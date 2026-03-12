import java.util.*;
import java.io.*;

class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        
        int[][] dp = new int[30][30];
        
        for(int i = 0; i<30; i++){
            dp[i][0] = dp[i][i] = 1;
        } 
        
        for(int i = 2; i<30; i++){
            for(int j = 1; j<30; j++){
                dp[i][j] = dp[i-1][j-1] + dp[i-1][j];
            }
        }
        
        
        for(int t = 0; t<T; t++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            
            sb.append(dp[b][a]).append("\n");            
        }
        
        System.out.println(sb);
		   
    }
}