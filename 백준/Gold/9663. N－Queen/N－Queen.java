import java.util.*;
import java.io.*;

class Main{
    private static int N;
    private static int answer;
    private static boolean[] width, q1, q2;
    
    private static void backtrack(int q){
        if(q==N){
            answer++;
            return;
        }
        
        for(int i = 1; i<=N; i++){
            if(!(width[i]||q1[q+i]||q2[q-i+N])){
                width[i] = q1[q+i] = q2[q-i+N] = true;
                backtrack(q+1);
                width[i] = q1[q+i] = q2[q-i+N] = false;
                
            }
        }
    }
    
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        answer = 0;
        width = new boolean[N+1];
        q1 = new boolean[N*2];
        q2 = new boolean[N*2];
        
        backtrack(0);
        
        System.out.println(answer);
        
    }
}