import java.util.*;
import java.io.*;

class Main{
    private static long[] dp;
    
    private static long fadoban(int n){
        if(n==0) return 0;
        if(dp[n]!=0) return dp[n];
        else return dp[n] = fadoban(n-2) + fadoban(n-3);
    }
    
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        dp = new long[101];
        dp[1] = 1;
        dp[2] = 1;
        dp[3] = 1;
        
        int T = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
        
        
        for(int i = 0; i<T; i++){
            int k = Integer.parseInt(br.readLine());
            sb.append(fadoban(k)).append("\n");
        }
        
        System.out.println(sb);
       
    }
}