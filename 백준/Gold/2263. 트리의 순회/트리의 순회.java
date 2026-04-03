import java.util.*;
import java.io.*;

class Main{
    static StringBuilder sb = new StringBuilder();
    private static int[] post, inIndex;
    
    private static void getPreOrder(int inStart, int inEnd, int postStart, int postEnd){
        if(inStart>inEnd || postStart>postEnd) return;
        
        int end = post[postEnd];
        sb.append(end).append(" ");
        
        int endIndex = inIndex[end];
        int size = endIndex - inStart;
        
        getPreOrder(inStart, endIndex-1, postStart, postStart+size-1);
        getPreOrder(endIndex+1, inEnd, postStart+size, postEnd-1);
    }
    
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        
        post = new int[n+1];
        inIndex = new int[n+1];
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 1; i<=n; i++){
            int k = Integer.parseInt(st.nextToken());
            inIndex[k] = i;
        }
        
        st = new StringTokenizer(br.readLine());
        for(int i = 1; i<=n; i++){
            int k = Integer.parseInt(st.nextToken());
            post[i] = k;
        }
        
        getPreOrder(1,n,1,n);
        System.out.println(sb);
    }
}