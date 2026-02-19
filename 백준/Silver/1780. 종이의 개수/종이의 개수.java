import java.util.*;
import java.io.*;

class Main{
    private static int[][] arr;
    private static int[] answer = new int[3];
    
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
            answer[arr[row][col]+1] += 1;
            return;
        }
        
        int newSize = size/3;
        
        partition(row, col, newSize);
        partition(row, col+newSize, newSize);
        partition(row, col+newSize*2, newSize);
        
        partition(row+newSize, col, newSize);
        partition(row+newSize, col+newSize, newSize);
        partition(row+newSize, col+newSize*2, newSize);
        
        partition(row+newSize*2, col, newSize);
        partition(row+newSize*2, col+newSize, newSize);
        partition(row+newSize*2, col+newSize*2, newSize);
    }
    
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        arr = new int[n][n];
        
        for(int i = 0; i<n; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j = 0; j<n; j++){
                arr[i][j] = Integer.parseInt(st.nextToken());
            }    
        }
        
        partition(0,0,n);
        
        for(int i:answer) System.out.println(i);
		
    }
}