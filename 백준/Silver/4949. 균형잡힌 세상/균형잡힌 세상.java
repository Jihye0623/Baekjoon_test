import java.util.*;
import java.io.*;

class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        HashMap<Character, Character> map = new HashMap<>();
        map.put(')','(');
        map.put(']','[');
        StringBuilder sb = new StringBuilder();  
                      
        while(true){
            String temp = br.readLine();
            if(temp.equals(".")) break;

            Stack<Character> stack = new Stack<>();
            int flag = 0;
            for(int i = 0; i<temp.length(); i++){
                char c = temp.charAt(i);
                if (c=='('||c==')'||c=='['||c==']'){
                    if(map.containsKey(c)){
                        if(!stack.isEmpty() && stack.peek() == map.get(c)) stack.pop();
                        else{
                            flag = 1;
                            break;
                        }
                    }
                    else{
                        stack.push(c);
                    }
                }
                else continue;
            }
            if(!stack.isEmpty() || flag == 1) sb.append("no");
            else sb.append("yes");
            sb.append("\n");
        }
        
        System.out.println(sb.toString());
    }
}