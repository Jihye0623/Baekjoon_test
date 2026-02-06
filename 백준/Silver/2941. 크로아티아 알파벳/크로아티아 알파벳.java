import java.util.*;
import java.io.*;

class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        String[] msgs = {"c=","c-","dz=", "d-", "lj", "nj", "s=","z="};

        
        for(String msg:msgs){
            str = str.replace(msg, "*");
        }
        
        System.out.println(str.length());
    }
}