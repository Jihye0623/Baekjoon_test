import java.util.*;
import java.io.*;

class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int x = Integer.parseInt(st.nextToken());
        
        st = new StringTokenizer(br.readLine());
        int[] arr = new int[n];
        for(int i = 0; i<n; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }
               
		StringBuilder sb = new StringBuilder();
        
        for(int i = 0; i<n; i++){
            if(arr[i]<x) sb.append(arr[i]).append(" ");
        }
        
        System.out.println(sb.toString());
    }
}