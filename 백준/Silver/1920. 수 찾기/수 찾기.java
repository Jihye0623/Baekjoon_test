import java.util.*;
import java.io.*;

class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] arr = new int[n];
        for(int i = 0; i<n; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);
        StringBuilder sb = new StringBuilder();
        
        int m = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i<m; i++){
            int k = Integer.parseInt(st.nextToken());
            int start = 0, end = n-1;
            int flag = 0;
            while(start<=end){
                int mid = (start+end)/2;
                
                if(arr[mid]==k) {
                    flag = 1;
                    break;
                }
                else if (arr[mid]<k) start = mid+1;
                else end = mid -1;
            }
            
            if(flag==0) sb.append(0).append("\n");
            else sb.append(1).append("\n");
        }
		
        System.out.println(sb);
    }
}