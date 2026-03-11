import java.util.*;
import java.io.*;

class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());    
		int K = Integer.parseInt(st.nextToken());    
        
        int answer = 0;
        int j = 0;
        for(int i = 1; i<=N; i++){
            if(N%i==0){
                j++;
                if(j==K){
                    answer = i;
                    break;
                }
            }
        }
        
        
        System.out.println(answer);
        
    }
}