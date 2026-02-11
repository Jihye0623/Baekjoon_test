import java.util.*;
import java.io.*;

class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int m = Integer.parseInt(br.readLine());
        int n = Integer.parseInt(br.readLine());
        ArrayList<Integer> list = new ArrayList<>();
        
        for(int i = m; i<=n; i++){
            int flag = 1;
            for(int j = 2; j*j<=i; j++){
                if(i%j==0){
                    flag = 0;
                    break;
                }
            }
            
            if(i!=1 && flag==1) list.add(i);
        }
        if(list.size()==0) System.out.println(-1);
        else{
            int total = 0;
            for(int i:list) total+= i;
            System.out.println(total);
            System.out.println(Collections.min(list));   
        }
        
    }
}