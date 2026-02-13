import java.util.*;
import java.io.*;

class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        HashSet<String> set = new HashSet<>();
        
        for(int i = 0; i<str.length(); i++){
            String temp = "";
            for(int j = i; j<str.length(); j++){
                temp += str.charAt(j);
                set.add(temp);
            }
        }
        
        System.out.println(set.size());
        
    }
}