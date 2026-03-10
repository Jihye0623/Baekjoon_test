import java.util.*;
import java.io.*;

class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
		String str = st.nextToken();
        int b = Integer.parseInt(st.nextToken());
        
        int answer = 0;
        int n = 0;
        for(int i = str.length()-1; i>=0; i--){
            char c = str.charAt(i);
            if(Character.isDigit(c)){
                int temp = (int)(c-'0');
                answer += temp * (int)Math.pow(b,n++);
            }
            else{
                int temp = (int)(c-'A') + 10;
                answer += temp * (int)Math.pow(b,n++);
            }
        }
        
        System.out.println(answer);
            
    }
}