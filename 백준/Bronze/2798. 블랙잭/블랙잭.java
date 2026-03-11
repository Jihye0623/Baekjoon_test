import java.io.*;
import java.util.*;

class Main{
    private static int M, answer;
    private static void combination(int idx, int[] order, int result, int len){
        if(len==3){
            if(result<=M){
                answer = Math.max(answer, result);
            }
            return;
        }
        
        for(int i = idx; i<order.length; i++){
            combination(i+1, order, result+order[i], len+1);
        }
    }
    
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        
        answer = 0;
        int[] arr = new int[N];
        
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i<N; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }
        
        combination(0, arr, 0, 0);
        
        System.out.println(answer);
        
    }
}