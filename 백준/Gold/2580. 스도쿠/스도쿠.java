import java.util.*;
import java.io.*;

class Main{
    private static int[][] map;
    private static int[][] answer;
    
    private static class Node{
        int x, y;
        public Node(int x, int y){
            this.x = x;
            this.y = y;
        }
    }
    
    private static boolean validRow(int row, int num){
        for(int i = 0; i<9; i++){
            if(map[row][i] == num) return false;
        }
        return true;
    }
    private static boolean validCol(int col, int num){
        for(int i = 0; i<9; i++){
            if(map[i][col] == num) return false;
        }
        return true;
    }
    private static boolean validSpot(int row, int col, int num){
        int mapRow = (row/3)*3;
        int mapCol = (col/3)*3;
        for(int i = mapRow; i<mapRow+3; i++){
            for(int j = mapCol; j<mapCol+3; j++){
                if(map[i][j] == num) return false;
            }
        }
        return true;
    }
    
    private static boolean valid(int row, int col, int num){
        return validRow(row, num) && validCol(col, num) && validSpot(row, col, num);
    }
    
    private static Node isBlank(){
        for(int i = 0; i<9; i++){
            for(int j =0; j<9; j++){
                if(map[i][j] == 0) return new Node(i,j);
            }
        }
        return null;
    }
    
    private static void backTrack(){
        Node now = isBlank();
        if(now == null) {
            for(int i = 0; i<9; i++){
                for(int j =0; j<9; j++)
                    answer[i][j] = map[i][j];
            }
            return;
        }
        
        for(int i = 1; i<=9; i++){
            if(valid(now.x, now.y, i)){
                map[now.x][now.y] = i;
                backTrack();
                map[now.x][now.y] = 0;
            }
        }
    }
    
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        map = new int[9][9];
        answer = new int[9][9];
        
        for(int i = 0; i<9; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());    
            for(int j = 0; j<9; j++){
                map[i][j] = Integer.parseInt(st.nextToken());        
            }
        }
        
        backTrack();
		    
        StringBuilder sb = new StringBuilder();
        
        for(int i = 0; i<9; i++){
            for(int j = 0; j<9; j++){
                sb.append(answer[i][j] + " ");
            }
            sb.append("\n");
        }
        
        
        System.out.println(sb);
    }
}