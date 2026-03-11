import java.util.*;
import java.io.*;

class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int answer = 0;

        StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i = 0; i<n; i++){
            boolean flag = true;
            int k = Integer.parseInt(st.nextToken());
            if(k==1) continue;
            for(int j=2;j<k;j++){
                if(k%j==0){
                    flag = false;
                    break;
                }
            }
            if(flag) answer++;
        }
        
                
        System.out.println(answer);
    }
}