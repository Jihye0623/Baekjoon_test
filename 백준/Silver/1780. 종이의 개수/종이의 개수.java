import java.util.*;
import java.io.*;

class Main{
    private static int[][] map;
    private static int num1 = 0, num2 = 0, num3 = 0;
    
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
            if(num==-1) num1++;
            else if(num==0) num2++;
            else if(num==1) num3++;
            return;
        }
        else{

            int newSize = size/3;
            divide(row, col, newSize);
            
            divide(row, col+newSize, newSize);
            divide(row, col+newSize*2, newSize);
            
            divide(row+newSize, col, newSize);
            divide(row+newSize*2, col, newSize);
            
            divide(row+newSize, col+newSize, newSize);   
            divide(row+newSize, col+newSize*2, newSize);   
            divide(row+newSize*2, col+newSize, newSize);  
            divide(row+newSize*2, col+newSize*2, newSize);   
        }
        
    }
    
    private static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        
        map = new int[n][n];
        
        for(int i = 0; i<n; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j = 0; j<n; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        divide(0,0,n);
        
        System.out.println(num1);
        System.out.println(num2);
        System.out.println(num3);
    }
}