import java.util.*;
import java.io.*;

class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int k = Integer.parseInt(br.readLine());
        Stack<Integer> stack = new Stack<>();
        
        for(int i = 0; i<k; i++){
            int n = Integer.parseInt(br.readLine());
            if(n!=0) stack.push(n);
            else if (n==0 && !stack.isEmpty()) stack.pop();
        }
        int total = 0;
        for(int i : stack) total += i;
        System.out.println(total);
    }
}