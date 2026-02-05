import java.util.*;
import java.io.*;

class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        String input = "";
        StringTokenizer st;
        while((input=br.readLine())!=null && !input.isEmpty()){
            st = new StringTokenizer(input);
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            
            sb.append(a+b).append("\n");
        }
        
        System.out.println(sb.toString());
        
		    
    }
}