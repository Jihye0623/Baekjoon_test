import java.io.*;
import java.util.*;

class Main{
    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));        
        int n = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();
        
        for(int i = 0; i<n; i++){
            Stack<Character> stack = new Stack<>();
            String str = br.readLine();
            boolean flag = true;
            
            for(int j = 0; j<str.length(); j++){
                char c = str.charAt(j);
                if(c=='(') stack.push(c);
                else{
                    if(stack.isEmpty()) flag = false;
                    else stack.pop();
                }
            }

            if(!flag || !stack.isEmpty()) sb.append("NO\n");
            else sb.append("YES\n");
        }

        System.out.println(sb);

    }
}