import java.util.*;
import java.io.*;

class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());    
		int k = Integer.parseInt(st.nextToken());    
        
        int[] tree = new int[n];
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i<n; i++){
            tree[i] = Integer.parseInt(st.nextToken());
        }
        
        Arrays.sort(tree);
        long min = 0, max = tree[n-1]+1, mid;
        
        while(min<max){
            mid = (max+min)/2;
            long sum = 0;
            for(int i = 0; i<n; i++){
                if(mid>=tree[i]) continue;
                sum += tree[i] - mid;
            }
            if(sum>=k){
                min = mid+1;
            }else{
                max = mid;
            }
        }
        
        System.out.println(min-1);
    }
}