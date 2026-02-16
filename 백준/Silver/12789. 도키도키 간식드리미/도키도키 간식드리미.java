import java.util.*;
import java.io.*;

class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        Stack<Integer> stack = new Stack<>();
        int t = 1;
        
        String answer = "Nice";
        for(int i = 0; i<n ; i++){
            int k = Integer.parseInt(st.nextToken());
            if(k==t) t++;
            else stack.push(k);
            while(!stack.isEmpty() && stack.peek()==t){
                stack.pop();
                t++;
            }
        }
        if(!stack.isEmpty()) answer = "Sad";
        
        System.out.println(answer);
    }
}