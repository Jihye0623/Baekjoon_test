import java.util.*;
import java.io.*;

class Main{
    
    private static int[] in, post, inIndex;
    private static StringBuilder sb = new StringBuilder();
    
    private static void getPreOrder(int inStart, int inEnd, int postStart, int postEnd){
        if(inStart>inEnd || postStart>postEnd) return;
        
        int root = post[postEnd];
        
        sb.append(root).append(" ");
        
        int rootIdx = inIndex[root];
        
        int leftSize = rootIdx - inStart;
        
        getPreOrder(inStart, rootIdx-1, postStart, postStart+leftSize-1);
        getPreOrder(rootIdx+1, inEnd, postStart+leftSize, postEnd - 1);
        
    }
    
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        
        in = new int[n+1];
        post = new int[n+1];
        inIndex = new int[n+1];
        
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 1; i<=n; i++){
            in[i] = Integer.parseInt(st.nextToken());
            inIndex[in[i]] = i;
        }
        
        st = new StringTokenizer(br.readLine());
        for(int i = 1; i<=n; i++){
            post[i] = Integer.parseInt(st.nextToken());
        }
        
        getPreOrder(1, n, 1, n);
        System.out.println(sb);
        
		
    }
}