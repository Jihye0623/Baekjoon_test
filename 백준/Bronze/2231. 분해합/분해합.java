import java.util.*;
import java.io.*;

class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        
        int answer = 1;
        
        while(true){
            int temp = answer;
            int sum = temp;
            while (temp>0){
                sum += temp%10;
                temp/=10;
            }
            if(sum==n) break;
            else if(answer>n){
                answer = 0;
                break;
            }
            answer += 1;
        }
        
        System.out.println(answer);
    }
}