import java.util.*;
import java.io.*;

class Main{
    private static int gcd(int a, int b){
        if(b==0) return a;
        else return gcd(b,a%b);
    }
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] tree = new int[n];
        for(int i = 0; i<n; i++){
            tree[i] = Integer.parseInt(br.readLine());
        }
        
        int[] distance = new int[n-1];
        for(int i = 0; i<n-1; i++){
            distance[i] = tree[i+1] - tree[i];
        }
        
        int g = distance[0];
        for(int i = 1; i<n-1; i++){
            g = gcd(g, distance[i]);
        }
        
        int cnt = 0;
        for(int i = 0; i<n-1; i++){
            cnt += distance[i]/g -1;
        }
        
        System.out.println(cnt);
        
    }
}