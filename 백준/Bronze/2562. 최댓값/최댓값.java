import java.util.*;
import java.io.*;

class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        ArrayList<Integer> list = new ArrayList<>();
        for(int i = 0; i<9; i++){
            list.add(Integer.parseInt(br.readLine()));
        }
        
        int maxNum = Collections.max(list);
        int maxIdx = list.indexOf(maxNum);
        
        System.out.println(maxNum);
        System.out.println(maxIdx+1);
    }
}