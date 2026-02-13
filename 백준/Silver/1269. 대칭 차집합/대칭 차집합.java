import java.util.*;
import java.io.*;

class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        HashSet<Integer> setA = new HashSet<>();
        HashSet<Integer> setB = new HashSet<>();
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i<a; i++){
            setA.add(Integer.parseInt(st.nextToken()));
        }
        
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i<b; i++){
            setB.add(Integer.parseInt(st.nextToken()));
        }
        
        HashSet<Integer> set = new HashSet<>();
        for(int k:setA){
            if(!setB.contains(k)) set.add(k);
        }
        for(int k:setB){
            if(!setA.contains(k)) set.add(k);
        }
        System.out.println(set.size());
    }
}