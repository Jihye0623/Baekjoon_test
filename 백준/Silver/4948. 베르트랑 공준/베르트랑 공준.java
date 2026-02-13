import java.util.*;
import java.io.*;

class Main{
    private static final int MAX= 123456;
    private static boolean[] board = new boolean[2*MAX+1];
    private static int idx = 0;
    
    private static void init(){
        board[0] = board[1] = true;
        for(int i = 2; i<=2*MAX; i++){
            if(board[i]==false){
                for(int j = i*2; j<=2*MAX; j=j+i){
                    board[j] = true;
                }
            }
        }
    }
    
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        init();
        
		StringBuilder sb = new StringBuilder();
        while(true){
            int n = Integer.parseInt(br.readLine());
            if(n==0) break;
            int cnt = 0;
            for(int i =n+1; i<=2*n; i++){
                if(board[i]==false) cnt++;
            }
            sb.append(cnt).append("\n");
        }
        
        System.out.println(sb.toString());
    }
}