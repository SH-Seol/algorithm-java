package programmers.implement.colrowspin;

class Solution {
    public int[] solution(int rows, int columns, int[][] queries) {
        int[][] arr = new int[rows + 1][columns + 1];
        int tmp = 1;
        for(int i = 1; i <= rows; i++){
            for(int j = 1; j <= columns; j++){
                arr[i][j] = tmp;
                tmp++;
            }
        }
        int[] mins = new int[queries.length];
        for(int i = 0; i < queries.length; i++){
            int sx = queries[i][0];
            int sy = queries[i][1];
            int ex = queries[i][2];
            int ey = queries[i][3];
            int tmp1 = arr[sx][sy];
            int min = tmp1;
            for(int y = sy; y < ey; y++){
                int tmp2 = arr[sx][y + 1];
                arr[sx][y+1] = tmp1;
                tmp1 = tmp2;
                min = Math.min(min, tmp1);

            }
            for(int x = sx; x < ex; x++){
                int tmp2 = arr[x + 1][ey];
                arr[x + 1][ey] = tmp1;
                tmp1 = tmp2;
                min = Math.min(min, tmp1);
            }
            for(int y = ey; y > sy; y--){
                int tmp2 = arr[ex][y - 1];
                arr[ex][y-1] = tmp1;
                tmp1 = tmp2;
                min = Math.min(min, tmp1);
            }
            for(int x = ex; x > sx; x--){
                int tmp2 = arr[x - 1][sy];
                arr[x - 1][sy] = tmp1;
                tmp1 = tmp2;
                min = Math.min(min, tmp1);
            }
            mins[i] = min;
        }
        return mins;
    }
}