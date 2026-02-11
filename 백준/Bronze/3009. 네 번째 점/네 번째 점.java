import java.util.*;
import java.io.*;

class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        HashSet<Integer> setX = new HashSet<>();
        HashSet<Integer> setY = new HashSet<>();
        
		for(int i = 0; i<3; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            if (setX.contains(a)) setX.remove(a);
            else setX.add(a);
            if (setY.contains(b)) setY.remove(b);
            else setY.add(b);
        }

        for(int i:setX) System.out.print(i + " ");
        for(int i:setY) System.out.println(i);
        
    }
}