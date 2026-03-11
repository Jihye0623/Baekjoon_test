import java.io.*;
import java.util.*;

class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int x = Integer.parseInt(br.readLine());
        
        int row = 1, col = 1;
        int temp = 1;
        boolean flag = true; 
        while(true){
            if(temp==x) break;
            temp += 1;
            if(flag){
                if(row==1){
                    col++;
                    flag = !flag;
                }
                else{
                    row--;
                    col++;
                }
            }
            else{
                if(col==1){
                    row++;
                    flag = !flag;
                }
                else{
                    row++;
                    col--;
                }
                
            }
        }
        
        StringBuilder sb = new StringBuilder();
        sb.append(row).append("/").append(col);
        System.out.println(sb);
    }
}