package bj.bfs_dfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ7576 {
    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static int[][] maps;
    static int m,n;
    static Queue<int[]> queue = new LinkedList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        m = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());
        maps = new int[n][m];

        for(int i = 0;i < n;i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 0;j < m;j++) {
                maps[i][j] = Integer.parseInt(st.nextToken());
                if(maps[i][j] == 1){
                    queue.add(new int[]{i,j});
                };
            }
        }

        System.out.println(bfs());

    }

    public static int bfs() {
        //bfs 과정
        while(!queue.isEmpty()) {
            int[]cur = queue.poll();

            int curX = cur[0];
            int curY = cur[1];

            for(int i = 0; i < 4; i++){
                int nx = curX + dx[i];
                int ny = curY + dy[i];


                if(nx < 0 || ny < 0 || nx > n-1|| ny > m-1){
                    continue;
                }
                if(maps[nx][ny] == 0){
                    maps[nx][ny] = maps[curX][curY] + 1;
                    queue.add(new int[]{nx,ny});
                }
            }
        }
        //채워지지 않은 칸이 있는지 확인하고 max 값 찾는 과정
        int max = Integer.MIN_VALUE;
        for(int i = 0;i < n;i++) {
            for(int j = 0;j < m;j++) {
                if(maps[i][j] == 0){
                    return -1;
                }
                else{
                    max = Math.max(max, maps[i][j]);
                }
            }
        }
        return max - 1;
    }
}
