import java.util.*;
import java.io.*;

class Main{
    private static int N, answer;
    private static boolean[] width, q1, q2;
    private static void backTrack(int row){
        if(row == N) {
            answer++;
            return;
        }
        
        for(int i = 0; i<N; i++){
            if(!width[i] && !q1[row-i+N] && !q2[row+i]){
                width[i] = q1[row-i+N] = q2[row+i] = true;
                backTrack(row+1);
                width[i] = q1[row-i+N] = q2[row+i] = false;
            }
        }
        
    }
    
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        answer = 0;
        
        width = new boolean[N];
        q1 = new boolean[N*2];
        q2 = new boolean[N*2];
        
        backTrack(0);
        
        System.out.println(answer);
        
    }
}