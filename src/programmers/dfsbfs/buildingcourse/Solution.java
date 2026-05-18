package programmers.dfsbfs.buildingcourse;

import java.util.*;

class Solution {
    PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[3] - b[3]);
    int[][][] visited;
    int[] dx = {-1, 1, 0, 0};
    int[] dy = {0, 0, -1, 1};
    int[][] bd;
    int answer = Integer.MAX_VALUE;
    int n;
    public int solution(int[][] board) {
        bd = board;
        n = board.length;
        visited = new int[n][n][4];
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                Arrays.fill(visited[i][j], Integer.MAX_VALUE);
            }
        }
        bfs();
        return answer;
    }
    public void bfs(){
        if(bd[1][0] != 1){
            pq.add(new int[]{1, 0, 1, 100});
            visited[1][0][1] = 100;
        }
        if(bd[0][1] != 1){
            pq.add(new int[]{0, 1, 3, 100});
            visited[0][1][3] = 100;
        }
        while(!pq.isEmpty()){
            int[] cur = pq.poll();
            int x = cur[0];
            int y = cur[1];
            int dir = cur[2];
            int cost = cur[3];

            if(x == n - 1 && y == n - 1){
                answer = Math.min(answer, cost);
            }

            for(int i = 0; i < 4; i++){

                int nx = x + dx[i];
                int ny = y + dy[i];
                int ncost = dir == i ? cost + 100 : cost + 600;

                //범위 넘기거나 이미 해당 위치의 값이 내가 가지고 있는 cost보다 작거나 벽인 경우
                if(nx < 0 || nx >= n || ny < 0 || ny >= n ||
                        visited[nx][ny][i] <= ncost || bd[nx][ny] == 1){
                    continue;
                }

                //방향이 같은 경우 직선도로를 생성
                visited[nx][ny][i] = ncost;
                pq.add(new int[]{nx, ny, i, ncost});
            }
        }
    }
}