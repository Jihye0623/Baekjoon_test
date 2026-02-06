import java.util.*;
import java.io.*;

class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder first = new StringBuilder(st.nextToken()).reverse();
        StringBuilder second = new StringBuilder(st.nextToken()).reverse();
        
        int a = Integer.parseInt(first.toString());
        int b = Integer.parseInt(second.toString());
        if(a>b) System.out.println(a);
        else System.out.println(b);
    }
}