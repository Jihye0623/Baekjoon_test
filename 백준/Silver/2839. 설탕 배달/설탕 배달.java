import java.util.*;
import java.io.*;

class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int max = 5001;
        int[] arr = new int[5001];
        for(int i = 0; i<=n; i++){
            arr[i] = max;
        }
        arr[3] = 1;
        arr[5] = 1;
        
        for(int i = 6; i<=n; i++){
            arr[i] = Math.min(arr[i-3], arr[i-5])+1;
        }
        
        if(arr[n]<max)
            System.out.println(arr[n]);
        else
            System.out.println(-1);
        
    }
}