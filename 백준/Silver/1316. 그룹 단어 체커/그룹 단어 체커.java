import java.util.*;
import java.io.*;

class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int count = 0;
        Stack<Character> stack;
        HashSet<Character> set;
        for(int i = 0; i<n; i++){
            String str = br.readLine();
            stack = new Stack<>();
            set = new HashSet<>();
            for(int j = 0; j<str.length(); j++){
                char c = str.charAt(j);
                if(!stack.isEmpty() && stack.peek()==c) stack.pop();
                stack.push(c);
                set.add(c);
            }
            if(stack.size()==set.size()) count++;
        }
        
        System.out.println(count);
    }
}