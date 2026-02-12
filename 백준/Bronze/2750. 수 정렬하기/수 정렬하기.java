import java.util.*;
import java.io.*;

class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        ArrayList<Integer> arr = new ArrayList<>();        
        for(int i = 0; i<n; i++) arr.add(Integer.parseInt(br.readLine()));
    
        Collections.sort(arr);
        StringBuilder sb = new StringBuilder();
        for(int a:arr) sb.append(a).append("\n");
        System.out.println(sb.toString());
    }
}