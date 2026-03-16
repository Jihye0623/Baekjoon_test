import java.util.*;
import java.io.*;

class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        long[] dp = new long[101];
        
        dp[1] = 1;
        dp[2] = 1;
        dp[3] = 1;
        dp[4] = 2;
        dp[5] = 2;
        for(int i = 6; i<101; i++){
            dp[i] = dp[i-2] + dp[i-3];
        }
        
        StringBuilder sb = new StringBuilder();
        
        for(int i = 0; i<n; i++){
            int k = Integer.parseInt(br.readLine());
            sb.append(dp[k]).append("\n");
        }
        
        
        System.out.println(sb);
        
    }
}