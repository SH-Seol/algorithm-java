package bj.bfs_dfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BJ1987 {
    static int m;
    static int n;
    static char[][] map;
    static boolean[] visited = new boolean[26];//알파벳 개수
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static int max = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] size = br.readLine().split(" ");  // 공백 기준으로 가로, 세로 값 받기
        m = Integer.parseInt(size[0]);
        n = Integer.parseInt(size[1]);

        map = new char[m][n];  // n이 세로, m이 가로

        // 지도 입력 받기
        for (int i = 0; i < m; i++) {
            String line = br.readLine();
            for (int j = 0; j < n; j++) {
                map[i][j] = line.charAt(j);  // 한 글자씩 입력
            }
        }

        dfs(0, 0, 1);

        System.out.println(max);
    }


    public static void dfs(int x, int y, int count){
        //
        visited[map[x][y] - 'A'] = true;
        max = Math.max(max, count);

        //다음 칸으로 넘어가기(재귀함수)
        for(int i = 0; i < 4; i++){
            int nx = x + dx[i];
            int ny = y + dy[i];
            if(nx >= 0 && nx < m && ny >= 0 && ny < n &&!visited[map[nx][ny] - 'A']){
                dfs(nx, ny, count+1);
            }
        }
        visited[map[x][y] - 'A'] = false;
    }

}
