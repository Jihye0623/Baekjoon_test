import java.util.*;
import java.io.*;

class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        String n = st.nextToken();
        int b = Integer.parseInt(st.nextToken());
        
        int answer = 0;
        for(char c:n.toCharArray()){
            int num;
            if('A'<=c && c<='Z') num = (int)(c-'A') + 10;
            else num = (int)(c-'0');
            answer = answer*b + num;
        }
        
        
        System.out.println(answer);
        
    }
}