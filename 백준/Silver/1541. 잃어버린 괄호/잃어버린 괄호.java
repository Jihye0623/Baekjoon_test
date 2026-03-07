import java.io.*;
import java.util.*;

class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split("-");
        int res = 0;
        
        for(int i = 0; i<input.length; i++){
            int temp = 0;
            String[] add = input[i].split("\\+");
            
            for(int j = 0; j<add.length; j++){
                temp += Integer.parseInt(add[j]); 
            }
            
            if(i==0) res += temp;
            else res -= temp;
        }
        
        System.out.println(res);
        
    }
}