import java.io.*;
import java.util.*;

class Main{
    private static int calculate(int n){
        int sum = 0;
        while(n>0){
            sum += n%10;
            n /= 10;
        }
        return sum;
    }
    
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        
        int answer = 0;
        for(int i = 1; i<n; i++){
            int temp = i + calculate(i);
            if(temp == n){
                answer = i;
                break;
            }
        }     
        
        System.out.println(answer);
        
    }
}