import java.util.*;
import java.io.*;

class Main{
    private static int[][] map;
    
    private static void divide(int row, int col, int size){
        
        int num = map[row][col];
        boolean flag = false;
        
        for(int i = row; i<row+size; i++){
            for(int j = col; j<col+size; j++){
                if(num!=map[i][j]){
                    flag = true;
                    break;
                }
            }
        }
        
        if(!flag){
            sb.append(num);
        }
        else{
            sb.append("(");

            int newSize = size/2;
            divide(row, col, newSize);
            divide(row, col+newSize, newSize);
            divide(row+newSize, col, newSize);
            divide(row+newSize, col+newSize, newSize);   
            sb.append(")");
        }
        
    }
    
    private static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        
        map = new int[n][n];
        
        for(int i = 0; i<n; i++){
            String str = br.readLine();
            for(int j = 0; j<n; j++){
                map[i][j] = (int)(str.charAt(j) - '0');
            }
        }

        divide(0,0,n);
        
        System.out.println(sb);
    }
}