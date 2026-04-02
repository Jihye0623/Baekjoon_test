import java.io.*;
import java.util.*;

class Main{
    private static StringBuilder sb;
    private static int[][] arr;
    
    private static void preorder(int x){
        if(x==-1) return;
        
        sb.append((char)(x+'A'));
        preorder(arr[x][0]);
        preorder(arr[x][1]);
    }
    
     private static void inorder(int x){
        if(x==-1) return;
        
        inorder(arr[x][0]);
        sb.append((char)(x+'A'));
        inorder(arr[x][1]);
    }
    
    private static void postorder(int x){
        if(x==-1) return;
        
        postorder(arr[x][0]);
        postorder(arr[x][1]);
        sb.append((char)(x+'A'));
    }
    
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n =Integer.parseInt(br.readLine());
        
        arr = new int[26][2];
        
        for(int i = 0; i<n; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = (int)(st.nextToken().charAt(0) - 'A');
            char b = st.nextToken().charAt(0);
            char c = st.nextToken().charAt(0);
            
            if(b=='.') arr[a][0] = -1;
            else arr[a][0] = (int)(b-'A');
            
            if(c=='.') arr[a][1] = -1;
            else arr[a][1] = (int)(c-'A');
        }
        
        sb = new StringBuilder();
        
        preorder(0);
        sb.append("\n");
        inorder(0);
        sb.append("\n");
        postorder(0);
        
        System.out.println(sb);
        
    }
}