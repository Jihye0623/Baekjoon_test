import java.util.*;
import java.io.*;

class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String string = br.readLine().trim();
        if(string.isEmpty()){
            System.out.println(0);
        }
        else{
            System.out.println(string.split(" ").length);
        }
    }
}