import java.util.*;
import java.io.*;

class Main{
    private static int[] temp;
    private static int cnt = 0, k, answer;
    
    
    private static void merge_sort(int[] a, int p, int r){
        if(p<r) {
            int q= (p+r)/2;
            merge_sort(a, p,q);
            merge_sort(a, q+1, r);
            merge(a, p, q, r);
        }
    }
    
    private static void merge(int[] a, int p, int q, int r){
        int i = p, j = q+1, t=0;
        while(i<=q && j<=r){
            if(a[i]<=a[j]) temp[t++] = a[i++];
            else temp[t++] = a[j++];
        }
        while(i<=q) temp[t++] = a[i++];
        while(j<=r) temp[t++] = a[j++];
        i = p;
        t = 0;
        while(i<=r) {
            a[i++] = temp[t++];
            cnt++;
            if(cnt == k) {
                answer = a[--i];
                break;
            }
        };
    }
    
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        
        int[] a = new int[n];
        temp = new int[n];
        answer = -1;
        
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i<n; i++){
            a[i] = Integer.parseInt(st.nextToken());
        }

        merge_sort(a, 0, n-1);
        System.out.println(answer);
        
    }
}