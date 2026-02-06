import java.util.*;
import java.io.*;

class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        int n = str.length();
        int flag = 1;
        for(int i = 0; i<n/2; i++){
            if(str.charAt(i)!=str.charAt(n-i-1)){
                flag = 0;
                break;
            }
        }
        
        System.out.println(flag);
    }
}