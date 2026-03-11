import java.io.*;
import java.util.*;

class Main{
    private static String[] answer = {"WBWBWBWB", "BWBWBWBW"};
    private static String[] map;
    private static int result; 
    
    private static void check(int x, int y){
        int cnt = 0;
        
      
        for(int i = 0; i<8; i++){
            int rowPattern = i%2;
            for(int j = 0; j<8; j++){
                if(map[x+i].charAt(y+j)!=answer[rowPattern].charAt(j)){
                    cnt++;
                }
            }
        }

        cnt = Math.min(64-cnt, cnt);
        
        result = Math.min(result, cnt);
    }
    
    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        
        map = new String[N];
        result = Integer.MAX_VALUE;
        
        for(int i = 0; i<N; i++){
            map[i] = br.readLine();    
        }
        
        for(int i = 0; i<=N-8; i++){
            for(int j = 0; j<=M-8; j++){
                check(i,j);    
            }
        }
        
        
        System.out.println(result);
    }
}