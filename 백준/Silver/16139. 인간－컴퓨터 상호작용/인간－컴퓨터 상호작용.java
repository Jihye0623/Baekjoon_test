import java.io.*;
import java.util.*;

class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
       
        String s = br.readLine();
        int q = Integer.parseInt(br.readLine());
        
        int n = s.length();
        int[][]dp = new int[26][n+1];

        for(int i = 0; i<n; i++){
            int charIdx = s.charAt(i)-'a';
            for(int j = 0; j<26; j++){
                dp[j][i+1] = dp[j][i];
            }
            dp[charIdx][i+1]++;
        }
        
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        
        for(int i = 0; i<q; i++){
            st = new StringTokenizer(br.readLine());
            char target = st.nextToken().charAt(0);
            int l = Integer.parseInt(st.nextToken());
            int r = Integer.parseInt(st.nextToken());
            
            int charIdx = target - 'a';
            
            int count = dp[charIdx][r+1] - dp[charIdx][l];
            sb.append(count).append("\n");
        }
        
        System.out.println(sb);
        
        
    }
}