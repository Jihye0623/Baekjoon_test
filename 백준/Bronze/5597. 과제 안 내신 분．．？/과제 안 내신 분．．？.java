import java.util.*;
import java.io.*;

class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] arr = new int[30];
        for(int i = 0; i<28; i++){
            arr[Integer.parseInt(br.readLine())-1] = 1;
        }
		StringBuilder sb = new StringBuilder();
        for(int i = 0; i<30; i++){
            if(arr[i]==0) sb.append(i+1).append("\n");
        }
        
        System.out.println(sb.toString());
        
    }
}