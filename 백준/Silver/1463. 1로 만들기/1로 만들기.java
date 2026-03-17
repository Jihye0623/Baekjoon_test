import java.util.*;
import java.io.*;

class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        
        if(n==1) {
            System.out.println(0);
            return;
        }
        else if(n==2 || n==3) {
            System.out.println(1);
            return;
        }
        
        int[] dp = new int[n+1];
        dp[2] = 1;
        dp[3] = 1;
        
        for(int i = 4; i<=n; i++){
            dp[i] = dp[i-1] + 1;
            if(i%2==0)
                dp[i] = Math.min(dp[i/2]+1, dp[i]);
            if(i%3==0)
                dp[i] = Math.min(dp[i/3]+1, dp[i]);
        }
        
        System.out.println(dp[n]);
    }
}