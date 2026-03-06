import java.io.*;
import java.util.*;

class Main{
    private static StringBuilder str;
    private static void recursive(int start, int size){
        if(size==1) return;
        int newSize = size/3;
        
        for(int i = start+newSize; i<start+2*newSize; i++){
            str.setCharAt(i, ' ');
        }
        
        recursive(start, newSize);
        recursive(start+2*newSize, newSize);
        
    }
    
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        
        String input ="";
        while((input=br.readLine())!= null && !input.isEmpty()){
            int n = (int)Math.pow(3,Integer.parseInt(input));
            str = new StringBuilder();
            for(int i = 0; i<n; i++){
                str.append("-");
            }
            recursive(0, n);
            sb.append(str).append("\n");
        }
        
        System.out.println(sb);
    }
}