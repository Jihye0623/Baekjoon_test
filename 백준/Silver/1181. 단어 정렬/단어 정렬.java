import java.util.*;
import java.io.*;

class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        HashSet<String> set = new HashSet<>();
        
        for(int i=0; i<n; i++){
            set.add(br.readLine());
        }

        ArrayList<String> list = new ArrayList<>();
        for(String str:set){
            list.add(str);
        }

        Collections.sort(list, new Comparator<String>(){
           @Override
            public int compare(String o1, String o2){
                int len1 = o1.length();
                int len2 = o2.length();

                int result = Integer.compare(len1,len2);
                if(result == 0) return o1.compareTo(o2);
                return result;
            }
        });

        StringBuilder sb = new StringBuilder();
        
        for(String str:list){
            sb.append(str).append("\n");
        }

        
        System.out.println(sb.toString());
    }
}