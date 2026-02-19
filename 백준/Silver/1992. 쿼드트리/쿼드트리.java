import java.util.*;
import java.io.*;

class Main{
    private static int[][] arr;
    private static StringBuilder sb = new StringBuilder();
    
    private static boolean check(int row, int col, int size){
        
        int c = arr[row][col];
        
        for(int i = row; i<row+size; i++){
            for(int j = col; j<col+size; j++){
                if(arr[i][j] != c) return false;
            }
        }
        
        return true;
        
    }
    
    private static void partition(int row, int col, int size){
       
       
        if(check(row, col, size)){
            sb.append(arr[row][col]);   
            return ;
        }
        
        int newSize = size/2;
        sb.append("(");
        partition(row, col, newSize);
        partition(row, col+ newSize, newSize);
        partition(row + newSize, col, newSize);
        partition(row + newSize, col + newSize, newSize);
        
        sb.append(")");
    }
    
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        arr = new int[n][n];
        
        for(int i = 0; i<n; i++){
            String str = br.readLine();
            for(int j = 0; j<n; j++){
                arr[i][j] = str.charAt(j) - '0';
            }
        }
        
        partition(0,0,n);
        System.out.println(sb);        
		
    }
}