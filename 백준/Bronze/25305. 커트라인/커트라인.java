import java.util.*;
import java.io.*;

class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        
        st = new StringTokenizer(br.readLine());
        ArrayList<Integer> arr = new ArrayList<>();
        for(int i = 0 ; i<n; i++){
            arr.add(Integer.parseInt(st.nextToken()));
        }
        
        Collections.sort(arr, Collections.reverseOrder());
        System.out.println(arr.get(k-1));
    }
}