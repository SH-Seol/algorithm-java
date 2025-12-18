package programmers.implement.biggestsquare;

class Solution
{
    int cnt = 0;
    public int solution(int [][]board)
    {
        for(int i = 0; i < board.length; i++){
            for(int j = 0; j < board[i].length; j++){
                if(board[i][j] == 1 && i != 0 && j != 0){
                    board[i][j] = Math.min(board[i][j - 1], Math.min(board[i - 1][j - 1], board[i - 1][j])) + 1;
                }
                cnt = Math.max(cnt, board[i][j]);
            }
        }
        return cnt * cnt;
    }

}