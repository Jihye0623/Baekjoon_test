import java.util.*;

class Solution {
    private static class Result{
        boolean win;
        int step;
        public Result(boolean win, int step){ 
            this.win = win;
            this.step = step;
        }
    }
    
    private static int ROW, COL;
    
    private static final int[] DR = {0,1,0,-1};
    private static final int[] DC = {-1,0,1,0};
    private static boolean[][] visited;
    private static int[][] Board;
    
    private static boolean isVaildPos(int r, int c){
        return 0<=r && r<ROW && 0<=c && c<COL;
    }
    
    private static Result recursive(int[] alpha, int[] beta, int step){
        int[] now = step % 2 == 0? alpha:beta;
        
        // [추가] 발판이 사라진 곳에 서 있으면 즉시 패배 (기존 로직 보완)
        if(visited[now[0]][now[1]]) return new Result(false, step);
        
        boolean canMove = false;
        ArrayList<Integer> winSteps = new ArrayList<>();
        ArrayList<Integer> loseSteps = new ArrayList<>();
        
        for(int i = 0; i<4; i++){
            int nr = now[0] + DR[i];
            int nc = now[1] + DC[i];
            
            if(isVaildPos(nr, nc) && !visited[nr][nc] && Board[nr][nc]==1){
                canMove = true;
                
                // [유지] 상대방과 겹쳤을 때 이동하면 즉시 승리 처리
                if(alpha[0] == beta[0] && alpha[1] == beta[1]){
                    winSteps.add(step + 1);
                    continue;
                }
                
                visited[now[0]][now[1]] = true;
                
                // [수정] 문법 오류 수정 (alpha: ... 제거)
                Result result = step%2==0 ? 
                    recursive(new int[]{nr,nc}, beta, step+1) : 
                    recursive(alpha, new int[]{nr, nc}, step+1);
                
                visited[now[0]][now[1]] = false;
                
                // [수정] 로직 정리: 상대가 지면(!result.win) -> 나는 이기는 경우임
                if(!result.win) {
                    winSteps.add(result.step);
                } else {
                    loseSteps.add(result.step);
                }
            }
        }
        
        // 이동할 곳이 없으면 패배
        if(!canMove)
            return new Result(false, step);
        
        // [수정] Minimax 핵심: 이길 수 있으면 '최소' 턴, 질 수밖에 없으면 '최대' 턴
        if(!winSteps.isEmpty()) {
            return new Result(true, Collections.min(winSteps));
        }
        
        return new Result(false, Collections.max(loseSteps));
    }
    
    public int solution(int[][] board, int[] aloc, int[] bloc) {
        Board = board;
        ROW = board.length;
        COL = board[0].length;
        visited = new boolean[ROW][COL];
        
        return recursive(aloc, bloc, 0).step;
    }
}