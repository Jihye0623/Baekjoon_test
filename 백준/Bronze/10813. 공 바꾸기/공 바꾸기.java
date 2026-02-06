import java.util.*;
import java.io.*;

class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int[] arr = new int[n];
        for(int q = 0; q<n; q++){
            arr[q] = q+1;
        }
        
        for(int q = 0; q<m; q++){
            st = new StringTokenizer(br.readLine());
            int i = Integer.parseInt(st.nextToken());
            int j = Integer.parseInt(st.nextToken());
            
            int temp = arr[i-1];
            arr[i-1] = arr[j-1];
            arr[j-1] = temp;
        }
        
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i<n; i++){
            sb.append(arr[i]).append(" ");
        }
        
        System.out.println(sb.toString());
    }
}