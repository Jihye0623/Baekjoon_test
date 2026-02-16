import java.util.*;
import java.io.*;

class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        
        ArrayDeque<Integer> queue = new ArrayDeque<>();
        for(int i = 0; i<n; i++){
            st = new StringTokenizer(br.readLine());
            String cmd = st.nextToken();
            if(cmd.equals("push")){
                int k = Integer.parseInt(st.nextToken());
                queue.addLast(k);
                continue;
            }
            else if (cmd.equals("pop")){
                if(queue.isEmpty()) sb.append(-1);
                else sb.append(queue.pollFirst());
            }
            else if (cmd.equals("size")){
                sb.append(queue.size());
            }
            else if (cmd.equals("empty")){
                if(queue.isEmpty()) sb.append(1);
                else sb.append(0);
            }
            else if (cmd.equals("front")){
                if(queue.isEmpty()) sb.append(-1);
                else sb.append(queue.getFirst());
            }
            else if (cmd.equals("back")){
                if(queue.isEmpty()) sb.append(-1);
                else sb.append(queue.getLast());
            }
            sb.append("\n");
        }
        
        System.out.println(sb.toString());
		    
    }
}