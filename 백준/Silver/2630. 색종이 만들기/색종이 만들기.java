import java.util.*;
import java.io.*;

class Main{
    private static int[][] arr;
    private static int n, white = 0, blue = 0;
    
    private static boolean colorCheck(int row, int col, int size){
        int color = arr[row][col];
        
        for(int i = row; i<row+size; i++){
            for(int j = col; j<col+size; j++){
                if(arr[i][j]!=color) return false;
            }
        }
        return true;
    }
    
    private static void function(int row, int col, int size){
        if(colorCheck(row, col, size)){
            if(arr[row][col]==0) white++;
            else blue++;
            return;
        }
        
        int newSize = size/2;
        function(row, col, newSize);
        function(row, col+newSize, newSize);
        function(row+newSize, col, newSize);
        function(row+newSize, col+newSize, newSize);
    }
        
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        n = Integer.parseInt(br.readLine());
        arr = new int[n][n];
        
        for(int i = 0; i<n; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j = 0; j<n; j++){
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        
        function(0,0,n);
        System.out.println(white);
        System.out.println(blue);
        
    }
}