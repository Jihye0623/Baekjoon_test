import java.util.*;
import java.io.*;

class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        
        while(true){
            ArrayList<Integer> arr = new ArrayList<>();
            int n = Integer.parseInt(br.readLine());
            if(n==-1) break;
            
            for(int i = 1; i<n; i++){
                if(n%i==0) arr.add(i);
            }
            int sum = 0;
            for(int i:arr) sum += i;
            if(sum==n){
                sb.append(n).append(" = ");
                for(int i = 0; i<arr.size()-1; i++) sb.append(arr.get(i)).append(" + ");
                sb.append(arr.get(arr.size()-1));
            }
            else{
                sb.append(n).append(" is NOT perfect.");
            }
            sb.append("\n");
        }
        
        System.out.println(sb);
    }
}