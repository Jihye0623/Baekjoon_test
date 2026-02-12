import java.util.*;
import java.io.*;

class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        ArrayList<int[]> list = new ArrayList<>();
        StringTokenizer st;
        for(int i = 0; i<n; i++){
            st = new StringTokenizer(br.readLine());    
            int x = Integer.parseInt(st.nextToken()); 
            int y = Integer.parseInt(st.nextToken());
            list.add(new int[]{x,y});
        }
        
        StringBuilder sb = new StringBuilder();
        Collections.sort(list, (o1,o2)-> Integer.compare(o1[0],o2[0])==0?Integer.compare(o1[1],o2[1]):Integer.compare(o1[0],o2[0]));
        for(int[] arr : list){
            sb.append(arr[0]).append(" ").append(arr[1]).append("\n");
        }
        
        System.out.println(sb.toString());
    }
}