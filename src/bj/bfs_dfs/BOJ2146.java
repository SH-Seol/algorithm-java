package bj.bfs_dfs;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;

public class BOJ2146 {
    static int n;
    static char[][] map;
    static int[][] same;
    static int result = Integer.MAX_VALUE;
    static boolean[][] visited;
    static int[]dx = {-1,1,0,0}, dy = {0,0,-1,1};
    static Queue<int[]> q = new ArrayDeque<>();
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        map = new char[n][n];
        same = new int[n][n];

        for(int i = 0; i < n; i++){
            String[] s = br.readLine().split(" ");
            for(int j = 0; j < n; j++){
                map[i][j] = s[j].charAt(0);
            }
        }

        int iNum = 1;

        //같은 섬 채우기
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                if(map[i][j] == '1' && same[i][j] == 0){
                    visited = new boolean[n][n];
                    visited[i][j] = true;
                    islands(i, j, iNum);
                    iNum++;
                }
            }
        }

        //섬 간 거리 구하기
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                if(map[i][j] == '1'){
                    q.clear();
                    visited = new boolean[n][n];
                    q.add(new int[]{i, j, 0});
                    visited[i][j] = true;
                    bfs(same[i][j]);
                }
            }
        }

        System.out.println(result);

    }
    //map을 돌면서 같은 섬인지 파악하고 그것에 맞는 숫자를 채워넣는다
    static void islands(int x, int y, int island){
        same[x][y] = island;
        for(int i = 0; i < 4; i++){
            int nx = x + dx[i];
            int ny = y + dy[i];

            if(nx >= n || nx < 0 || ny >= n || ny < 0 || visited[nx][ny] || map[nx][ny] == '0'){
                continue;
            }
            visited[nx][ny] = true;
            islands(nx, ny, island);
        }
    }

    //섬의 개수만큼의 크기를 가진 배열에 이제 각 섬 별로 출발했을 때 어디가 제일 빨리 도달하는지 파악하면 된다.
    static void bfs(int num){
        //bfs 돌리면서 다른 섬 발견하면 그 때의 result값을 비교해서 min처리하면 된다. 만약 내륙이라 주변에 온통 자신 뿐이면 그냥 끝내면 되지
        cycle: while(!q.isEmpty()){
            int[] tmp = q.poll();
            int cx = tmp[0];
            int cy = tmp[1];
            int cd = tmp[2];

            for(int i = 0; i < 4; i++){
                int nx = cx + dx[i];
                int ny = cy + dy[i];
                int nd = cd + 1;

                //범위 벗어나거나 똑같은 섬 번호이거나 이미 방문한 곳이면 넘어간다
                if(nx == n || ny == n || nx < 0 || ny < 0 || same[nx][ny] == num || visited[nx][ny]){
                    continue;
                }

                //섬을 찾았는데 그 섬이 다른 섬인 경우
                if(map[nx][ny] == '1' && same[nx][ny] != num){
                    result = Math.min(result, cd);
                    break cycle;
                }

                //그 외의 경우
                visited[nx][ny] = true;
                q.add(new int[]{nx, ny, nd});

            }
        }
    }
}
