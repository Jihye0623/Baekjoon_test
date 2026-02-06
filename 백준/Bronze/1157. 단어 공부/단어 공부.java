import java.util.*;
import java.io.*;

class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] alpha = new int[26];
        
        String str = br.readLine();
        str = str.toUpperCase();
        
        for(int i = 0; i<str.length(); i++){
            char c = str.charAt(i);
            alpha[c-'A']++;
        }
        
        int max = Arrays.stream(alpha).max().getAsInt();
        int count = 0;
        char answer = '?';
        for(int i = 0; i<alpha.length; i++){
            if(max == alpha[i]) {
                count++;
                answer = (char)('A' + i);
            }
        }
        
        if(count>1) System.out.println("?");
        else System.out.println(answer);
        
    }
}