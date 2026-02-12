import java.util.*;
import java.io.*;

class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str  = br.readLine();
        int[] arr = new int[str.length()];
        for(int i = 0; i<arr.length; i++){
            arr[i] = (int) (str.charAt(i)-'0');
        }
        Arrays.sort(arr);
        StringBuilder sb = new StringBuilder();
        for(int i = arr.length-1; i>=0; i--) sb.append(arr[i]);
        
        System.out.println(sb.toString());
    }
}