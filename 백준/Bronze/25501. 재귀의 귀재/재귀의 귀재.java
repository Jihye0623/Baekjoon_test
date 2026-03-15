import java.util.*;
import java.io.*;

class Main{
    public static int cnt;
    
    public static int recursion(String s, int l, int r, int c){
        if(l>=r) {
            cnt = c;
            return 1;
        }
        else if (s.charAt(l) != s.charAt(r)) {
            cnt = c;
            return 0;
        }
        else return recursion(s, l+1, r-1, c+1);
    }
    
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        
        int n = Integer.parseInt(br.readLine());
        
        
        for(int i = 0; i<n; i++){
            String word = br.readLine();
            cnt = 0;
            int k = recursion(word, 0, word.length()-1, 1);
            sb.append(k + " " + cnt + "\n");
            
        }
		System.out.println(sb);
    }
}