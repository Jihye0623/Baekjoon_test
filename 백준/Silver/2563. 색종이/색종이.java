import java.util.*;
import java.io.*;

class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[][] arr = new int[101][101];
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st;
        
        for(int i = 0; i<n; i++){
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            
            for(int j = x; j<x+10; j++){
                for(int k = y; k<y+10; k++){
                    arr[j][k] = 1;
                }
            }

        }
        
        int answer=  0;
         for(int j = 0; j<101; j++){
                for(int k = 0; k<101; k++){
                    if(arr[j][k]>0) answer++;
                }
         }
        
        System.out.println(answer);

		   
    }
}