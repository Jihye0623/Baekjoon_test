import java.util.*;
import java.io.*;

class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int cnt = 0;
        for(int i = 0; i<n; i++){
            int k = Integer.parseInt(st.nextToken());
            
            int flag = 1;
            for(int j = 2; j*j<=k; j++){
                if(k%j==0) {
                    flag = 0;
                    break;
                }
            }
            if(k!=1 && flag==1) cnt++;
        }
		
        System.out.println(cnt);
    }
}