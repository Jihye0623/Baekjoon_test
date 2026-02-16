import java.util.*;
import java.io.*;

class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
    
        HashSet<String> set = new HashSet<>();
        int k = 0, answer = 0;        
        for(int i = 0; i<n; i++){
            String str =  br.readLine();
            if(!str.equals("ENTER")) set.add(str);
            else{
                answer += set.size();
                set = new HashSet<>();
            }
        }

        answer += set.size();
        
        System.out.println(answer);
    }
}