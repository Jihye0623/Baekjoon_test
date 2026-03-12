import java.io.*;
import java.util.*;

class Main{
    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Stack<Integer> stack = new Stack<>();
        StringBuilder sb = new StringBuilder();
        
        int n = Integer.parseInt(br.readLine());
        
        for(int i = 0; i<n; i++){
            String[] token = br.readLine().split(" ");
            if(token.length == 1){
                int k = Integer.parseInt(token[0]);
                if(k==2) sb.append(stack.isEmpty()?-1:stack.pop());
                else if(k==3) sb.append(stack.size());
                else if(k==4) sb.append(stack.isEmpty()?1:0);
                else if(k==5) sb.append(stack.isEmpty()?-1:stack.peek());
                sb.append("\n");
            }
            else{
                stack.push(Integer.parseInt(token[1]));
            }
        }

        System.out.println(sb);
    }
}