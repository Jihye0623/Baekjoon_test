import java.util.*;
import java.io.*;

class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        
        int[] arr = new int[n];
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i<n; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }
        
        int answer =  0;
        for(int i = 0; i<k; i++){
            answer += arr[i];
        }
        
        int now = answer;
        for(int i = 1; i<=n-k; i++){
            now = now - arr[i-1] + arr[i+k-1];
            answer = Math.max(answer, now);
        }
        
        System.out.println(answer);
        
    }
}