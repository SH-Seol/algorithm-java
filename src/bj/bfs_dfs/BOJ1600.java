package bj.bfs_dfs;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ1600 {
    static int[] dx = {-1, 1, 0, 0, 2, 2, 1, 1, -1, -1, -2, -2};
    static int[] dy = {0, 0, -1, 1, 1, -1, 2, -2, 2, -2, 1, -1};
    static int[][] map;
    //나이트는 8개의 움직임이 있음 그래서 원숭이의 움직임은 총 12개임
    static int k, x, y;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        k = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        y = Integer.parseInt(st.nextToken());
        x = Integer.parseInt(st.nextToken());

        map = new int[x][y];

        for(int i = 0; i < x; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < y; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        if(x == 1 && y == 1){
            if(map[0][0] == 1){
                System.out.println(-1);
            }
            else{
                System.out.println(1);
            }
            return;
        }

        System.out.println(bfs(0, 0, 0, 0));

    }
    public static int bfs(int tx, int ty, int time, int n){
        Queue<int[]> q = new ArrayDeque<>();
        boolean[][][] visited = new boolean[x][y][k + 1]; // 0 1
        q.add(new int[]{tx, ty, time, n});
        //나이트로 움직이느냐, 그렇지 않느냐를 계속 판단해야한다. 나이트로 간 회수를 이미 초과했냐 안했냐도 판단해야한다.
        while(!q.isEmpty()){
            int[] cur = q.poll();
            int cx = cur[0];
            int cy = cur[1];
            int ct = cur[2];
            int cn = cur[3];
            for(int i = 0; i < 12; i++){
                //나이트 움직임이 불가능한데 i가 나이트 무빙을 가리키면 for문 더 진행할 이유 x
                if(k == cn && i >= 4){
                    continue;
                }
                int nx = cx + dx[i];
                int ny = cy + dy[i];
                int nt = ct + 1;
                if(nx == x - 1 && ny == y - 1){
                    return nt;
                }
                //범위 넘어가면 벗어난다.
                if(nx >= x || nx < 0 || ny >= y || ny < 0){
                    continue;
                }
                //나이트 움직임 가능하고 나이트 무빙을 가리키면 n에 1을 더한다. 그런데 먼저 움직임이 가능한 곳인지 판단해야한다.
                if(i >= 4){
                    if(visited[nx][ny][cn + 1] || map[nx][ny] == 1){
                        continue;
                    }
                    visited[nx][ny][cn + 1] = true;
                    q.add(new int[]{nx, ny, nt, cn + 1});
                }
                //일반 움직임의 경우
                else{
                    //이미 방문했거나 벽인 경우
                    if(visited[nx][ny][cn] || map[nx][ny] == 1){
                        continue;
                    }
                    //방문도 안했고 벽도 아닌 경우
                    visited[nx][ny][cn] = true;
                    q.add(new int[]{nx, ny, nt, cn});
                }
            }
        }

        return -1;
    }
}
