import java.util.*;
import java.io.*;

class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int M = Integer.parseInt(br.readLine());
        int N = Integer.parseInt(br.readLine());

        int sum = 0;
        int min = 0;

        for(int i = M; i<=N; i++){
            if(i==1) continue;
            boolean flag = true;
            for(int j = 2; j<i; j++){
                if(i%j==0){
                    flag = false;
                    break;
                }
            }
            
            if(flag) {
                if(sum==0) min = i;
                sum += i;
            }
        }
        
        if(sum == 0) System.out.println(-1);
        else {
            System.out.println(sum);
            System.out.println(min);
        }
    }
}