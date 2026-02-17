import java.util.*;
import java.io.*;

class Main{
    private static int result = -1;
    private static int cnt = 0;
    private static int K;
    private static int[] temp;

    private static void merge_sort(int[] A, int p, int r){
        if(p<r){
            int q = (p+r)/2;
            merge_sort(A, p, q);
            merge_sort(A, q+1, r);
            merge(A, p, q, r);
        }
    }
    
    private static void merge(int[] A, int p, int q, int r){
        int i = p;
        int j = q + 1;
        int t = 0;
        
        while(i<=q && j <= r){
            if(A[i]<=A[j]){
                temp[t++] = A[i++];
            }
            else{
                temp[t++] = A[j++];
            }
        }
        
        while(i<=q) temp[t++] = A[i++];
        while(j<=r) temp[t++] = A[j++];
        i = p;
        t = 0;
        while(i<=r){
            
            A[i++] = temp[t++];
            cnt++;
            
            if(cnt==K){
                result = A[i-1];
            }
            
            
        } 
    }
    
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        
        st = new StringTokenizer(br.readLine());
        int[] A = new int[n];
        temp = new int[n];
        for(int i = 0 ; i<n; i++){
            A[i] = Integer.parseInt(st.nextToken());
        }
        
        merge_sort(A, 0, n-1);
        
        System.out.println(result);
    }
}