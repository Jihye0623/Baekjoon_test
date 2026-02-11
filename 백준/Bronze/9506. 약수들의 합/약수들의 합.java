import java.util.*;
import java.io.*;

class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        StringBuilder sb = new StringBuilder();

        while(true){
            int n = Integer.parseInt(br.readLine());
            if(n == -1) break;
            
            ArrayList<Integer> list = new ArrayList<>();
            for(int i = 1; i<n;i++){
                if(n%i==0) list.add(i);
            }
            int total = 0;
            for(int i:list){
                total += i;
            }
            if(total==n) {
                sb.append(n).append(" = ");
                for(int i = 0; i<list.size()-1; i++){
                    sb.append(list.get(i)).append(" + ");
                }
                sb.append(list.get(list.size()-1)).append("\n");
            }
            else{
                sb.append(n).append(" is NOT perfect.").append("\n");
            }
            
        }        

        System.out.println(sb.toString());

    }
}