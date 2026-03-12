import java.io.*;
import java.util.*;

class Main{
    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));        

        HashMap<Character, Character> map = new HashMap<>();
        map.put(']', '[');
        map.put(')','(');
        
        StringBuilder sb = new StringBuilder();
        
        while(true){
            Stack<Character> stack = new Stack<>();
            String str = br.readLine();
            if(str.charAt(0) == '.') break;
            
            boolean flag = true;
            
            for(int j = 0; j<str.length(); j++){
                char c = str.charAt(j);
                if(c=='(' || c=='[') 
                    stack.push(c);
                else if(map.containsKey(c)){
                    if(stack.isEmpty()) {
                        flag = false;
                        break;
                    }
                    else {
                        if(stack.pop()!=map.get(c)) {
                            flag = false;
                            break;
                        }
                    }
                }
            }

            if(!flag || !stack.isEmpty()) sb.append("no\n");
            else sb.append("yes\n");
        }

        System.out.println(sb);

    }
}