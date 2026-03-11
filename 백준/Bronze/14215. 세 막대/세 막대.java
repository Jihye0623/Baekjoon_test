import java.util.*;
import java.io.*;

class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
		
        
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());
        int[] arr = {a,b,c};
        Arrays.sort(arr);
        
        if((arr[0] + arr[1]) > arr[2]) System.out.println(a+b+c);
        else System.out.println((arr[0] + arr[1]) *2 -1);
    }
}