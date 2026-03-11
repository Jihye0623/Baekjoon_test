import java.util.*;
import java.io.*;

class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        HashSet<Integer> setX = new HashSet<>();
        HashSet<Integer> setY = new HashSet<>();

        for(int i = 0; i<3; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            if(setX.contains(x)) setX.remove(x);
            else setX.add(x);
            
            if(setY.contains(y)) setY.remove(y);
            else setY.add(y);
        }
        
        for(int i:setX) System.out.print(i + " ");
        for(int i:setY) System.out.println(i);
        
        
    }
}