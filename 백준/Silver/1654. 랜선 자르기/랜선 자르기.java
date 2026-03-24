import java.util.*;
import java.io.*;

class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
		int k = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());
        
        long[] len = new long[k];
        long max = 0;
        
        for(int i = 0; i<k; i++){
            len[i] = Long.parseLong(br.readLine());
            max = Math.max(max, len[i]);
        }
        
        
        max++;
        long min = 1;
        long mid = 0;
        
        while(min<max){
            mid = (max+min) / 2;
            long sum = 0;
            for(int i = 0; i<k; i++){
                long t = len[i]/mid;
                sum += t;
            }
            if(sum<n) max = mid;
            else min = mid + 1;
            
        }
        
        System.out.println(min-1);
    }
}