import java.util.*;
import java.io.*;

class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        
        int[] arr = new int[n+1];
        
        for(int i = 1; i<=n; i++){
            arr[i] = Integer.parseInt(br.readLine());    
        }

        if(n==1) {
            System.out.println(arr[1]);
            return;
        }
        
        int[] dp = new int[n+1];
        dp[1] = arr[1];
        dp[2] = arr[2] + arr[1];
        
        for(int i = 3; i<=n; i++){
            int case1 = arr[i] + dp[i-2];
            int case2 = arr[i] + arr[i-1] + dp[i-3];
            int case3 = dp[i-1];
            dp[i] = Math.max(case1, Math.max(case2, case3));
        }
        
        System.out.println(dp[n]);
        
    }
}