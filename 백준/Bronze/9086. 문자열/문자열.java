import java.util.*;
import java.io.*;

class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        
        for(int i = 0; i<t; i++){
            String str = br.readLine();
            sb.append(str.charAt(0)).append(str.charAt(str.length()-1)).append("\n");
        }
        
        System.out.println(sb.toString());
		    
    }
}