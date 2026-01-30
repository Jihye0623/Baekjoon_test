import java.util.*;
import java.io.*;

class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int[][] arr = new int[10][10];
        
        for(int i = 1; i<10; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 1; j<10; j++){
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        int max = -1, ii=0, jj=0;
        for(int i = 1; i<10; i++){
            for(int j = 1; j<10; j++){
                if (arr[i][j]>max){
                    max = arr[i][j];
                    ii = i;
                    jj = j;
                }
            }
        }
        
        System.out.println(arr[ii][jj]);
        System.out.printf("%d %d", ii, jj);
    }
}