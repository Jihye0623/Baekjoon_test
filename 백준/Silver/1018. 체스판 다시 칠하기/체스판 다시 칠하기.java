import java.util.*;
import java.io.*;

class Main{

    public static int getMinCost(int startrow, int startcol, String[] board){
        String[] map = {"WBWBWBWB","BWBWBWBW"};

        int whiteVerCount = 0;

        for(int i = 0; i<8; i++){
            int row = startrow + i;
            for(int j = 0; j<8; j++){
                int col = startcol + j;

                if(board[row].charAt(col) != map[row%2].charAt(j)){
                    whiteVerCount++;
                }
            }
        }

        return Math.min(whiteVerCount, 64-whiteVerCount);
    }
    
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        String[] board = new String[n];

        for(int i = 0; i<n; i++){
            board[i] = br.readLine();
        }
        
        int count = Integer.MAX_VALUE;
        for(int i=0; i<=n-8; i++){
            for(int j=0; j<=m-8; j++){
                int resultCount = getMinCost(i,j,board);
                if(count>resultCount)
                    count = resultCount;
            }
        }
        System.out.println(count);
    }
}