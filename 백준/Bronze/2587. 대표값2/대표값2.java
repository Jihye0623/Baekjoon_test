import java.util.*;
import java.io.*;

class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        ArrayList<Integer> arr = new ArrayList<>();
        int total = 0;
        for(int i = 0; i<5; i++){
            int s = Integer.parseInt(br.readLine());
            total += s;
            arr.add(s);
        }
        
        Collections.sort(arr);
        System.out.println(total/5);
        System.out.println(arr.get(2));
        
    }
}