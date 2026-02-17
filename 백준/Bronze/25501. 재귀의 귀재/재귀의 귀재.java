import java.util.*;
import java.io.*;

class Main{
    private static int[] recursion(char[]s, int start, int end, int cnt){
        if(start>=end) return new int[]{1, cnt};
        else if(s[start]!=s[end]) return new int[]{0, cnt};
        else return recursion(s, start+1, end-1, cnt+1);
    }
    
    private static int[] isPalindrome(char[] s){
        return recursion(s, 0, s.length-1, 1);
    }
    
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        
        for(int i = 0; i<T; i++){
            String str = br.readLine();
            int[] result = isPalindrome(str.toCharArray());
            sb.append(result[0]).append(" ").append(result[1]).append("\n");
            
        }
        
        System.out.println(sb);
        
    }
}