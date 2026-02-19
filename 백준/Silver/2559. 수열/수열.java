import java.util.*;
import java.io.*;

class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        
        st = new StringTokenizer(br.readLine());
        int[] arr = new int[n];
        
        for(int i = 0; i<n; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int answer = 0;
        int value = 0;

        for(int i = 0; i<m; i++){
            value += arr[i];
        }
        answer = value;

        for(int i = 1; i<=n-m; i++){
            value = value - arr[i-1] + arr[i+m-1];
            answer = Math.max(value, answer);
        }

        System.out.println(answer);
    }
}