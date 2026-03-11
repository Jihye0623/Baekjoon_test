import java.util.*;
import java.io.*;

class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        
        long answer = 1;
        long number = 1;

        if(n==1) {
            System.out.println(1);
            return;
        }
        
        while(true){
            if(number >=  n) break;
            number += 6* answer;
            answer += 1;
            
        }
        
        System.out.println(answer);
    }
}