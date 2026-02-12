import java.util.*;
import java.io.*;

class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        ArrayList<String[]> list = new ArrayList<>();
		StringBuilder sb = new StringBuilder();
        
        StringTokenizer st;
        for(int i = 0; i<n; i++){
            st = new StringTokenizer(br.readLine());
            String age = st.nextToken();
            String name = st.nextToken();
            list.add(new String[]{age, name});
        }
        
        Collections.sort(list, new Comparator<String[]>(){
           @Override
            public int compare(String[]o1, String[]o2){
                int age1 = Integer.parseInt(o1[0]);
                int age2 = Integer.parseInt(o2[0]);
                return Integer.compare(age1, age2);
            }
        });
        
        for(String[] str : list){
            sb.append(str[0]).append(" ").append(str[1]).append("\n");
        }
        
        System.out.println(sb.toString());
    }
}