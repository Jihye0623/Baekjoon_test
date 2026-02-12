import java.util.*;
import java.io.*;

class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
		
        int[] array = new int[n];
        int[] arraySort = new int[n];
        HashMap<Integer, Integer> rankMap = new HashMap<Integer, Integer>();
        for(int i = 0; i<n; i++){
            array[i] = arraySort[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arraySort);
        
        int rank = 0;
        for(int value:arraySort){
            if(!rankMap.containsKey(value)){
                rankMap.put(value, rank);
                rank++;
            }
        }
        
        StringBuilder sb = new StringBuilder();
        for(int value:array){
            sb.append(rankMap.get(value)).append(' ');
        }
        
        System.out.println(sb);
        
        
    }
}