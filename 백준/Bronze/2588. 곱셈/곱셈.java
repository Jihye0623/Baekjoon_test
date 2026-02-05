import java.io.*;
import java.util.*;

class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int a = Integer.parseInt(br.readLine());
        String strB = br.readLine();
        int b = Integer.parseInt(strB);
        
        StringBuilder sb = new StringBuilder();
        
        for(int i = 2; i>=0; i--){
            int k = Character.getNumericValue(strB.charAt(i));
            sb.append(a*k).append("\n");
        }
        
        
        sb.append(a*b);
        System.out.println(sb.toString());
        
    }
}