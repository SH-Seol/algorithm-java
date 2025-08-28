package bj.bfs_dfs;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

//방문하지 않은 곳이었으면 큐에 값을 추가하고 근처를 조사한 후 방문하지 않고 1인 값은 큐에 다시 또 추가한다.

public class BOJ1926 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int res = 0;
        int s = 0;
        int tmpS = 1;
        int N;
        int M;
        Queue<int[]> q = new LinkedList<>();

        N = Integer.parseInt(st.nextToken());//세로
        M = Integer.parseInt(st.nextToken());//가로


        // 그림 초기화
        int[][] arr = new int[N][M];
        boolean[][] visited = new boolean[N][M];

        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < M; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int[] dx = {-1, 0, 1, 0};
        int[] dy = {0, -1, 0, 1};

        for(int i = 0; i < N; i++) {
            for(int j = 0; j < M; j++) {
                if(visited[i][j] || arr[i][j] == 0) {
                    continue;
                }
                tmpS = 1;
                res++;
                visited[i][j] = true;
                q.add(new int[]{i, j});
                while(!q.isEmpty()) {
                    int[] cur = q.poll();
                    for(int k = 0; k < 4; k++) {
                        int nx = cur[0] + dx[k];
                        int ny = cur[1] + dy[k];
                        if(nx < 0 || ny < 0 || nx >= N || ny >= M) {
                            continue;
                        }
                        if(visited[nx][ny] || arr[nx][ny] == 0){
                            continue;
                        }
                        q.add(new int[]{nx, ny});
                        visited[nx][ny] = true;
                        tmpS++;
                    }
                }
                s = Math.max(s, tmpS);
            }
        }
        bw.write(res + "\n");
        bw.write(s + "\n");
        bw.flush();
        bw.close();
        br.close();
    }
}
