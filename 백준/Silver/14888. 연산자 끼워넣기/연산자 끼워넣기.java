import java.util.*;
import java.io.*;

class Main{
    private static int MIN, MAX, n;
    private static int[] arr, op;
    
    private static void backTrack(int idx, int depth, int result){
        if(depth==n-1) {
            MIN = Math.min(MIN, result);
            MAX = Math.max(MAX, result);
            return;
        }
        
        for(int i = idx; i<n; i++){
            for(int j=0;j<4;j++){
                if(op[j]>0){
                    op[j]--;
                    if(j==0) backTrack(i+1, depth+1, result+arr[i]); 
                    else if(j==1) backTrack(i+1, depth+1, result-arr[i]); 
                    else if(j==2) backTrack(i+1, depth+1, result*arr[i]); 
                    else if(j==3) backTrack(i+1, depth+1, result/arr[i]); 
                    op[j]++;
                }
            }
        }
    }
    
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        
        arr = new int[n];
        op = new int[4];
        
        StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i = 0; i<n; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }
        
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i<4; i++){
            op[i] = Integer.parseInt(st.nextToken());
        }
        
        MIN = Integer.MAX_VALUE;
        MAX = Integer.MIN_VALUE;
        
        backTrack(1,0,arr[0]);
        
        System.out.println(MAX);
        System.out.println(MIN);
        
    }
}