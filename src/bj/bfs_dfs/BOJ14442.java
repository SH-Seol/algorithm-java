package bj.bfs_dfs;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ14442 {
    static int x, y, blocks;
    static Queue<int[]> q = new ArrayDeque<>();
    static char[][] map;
    static boolean[][][] visited;
    static int result = -1;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        x = Integer.parseInt(st.nextToken()); // 6
        y = Integer.parseInt(st.nextToken()); // 4
        blocks = Integer.parseInt(st.nextToken()); // 2

        map = new char[x][y];
        visited = new boolean[x][y][blocks + 1]; // 0번 깬 경우, 1번 깬 경우, 2번 깬 경우 모두 저장

        q.add(new int[]{0, 0, 0, 1}); // x, y, 블록 깬 횟수, 시간
        visited[0][0][0] = true;

        for(int i = 0; i < x; i++){
            String s = br.readLine();
            for(int j = 0; j < y; j++){
                map[i][j] = s.charAt(j);
            }
        }

        bfs();

        System.out.println(result);

    }
    public static void bfs(){

        int[] dx = {-1,1,0,0};
        int[] dy = {0,0,-1,1};

        while(!q.isEmpty()){
            int[] tmp = q.poll();
            int cx = tmp[0];
            int cy = tmp[1];
            int cb = tmp[2];
            int ct = tmp[3];

            if(cx == x - 1 && cy == y - 1){
                result = ct;
                return;
            }

            for(int i = 0; i < 4; i++){
                int nx = cx + dx[i];
                int ny = cy + dy[i];
                int nt = ct + 1;

                //범위 벗어난 경우
                if(nx == x || ny == y || nx < 0 || ny < 0){
                    continue;
                }
                //해당 위치가 벽인 경우
                if(map[nx][ny] == '1'){
                    //이미 벽을 최대로 뚫은 경우
                    if(cb == blocks || visited[nx][ny][cb + 1]){
                        continue;
                    }
                    //벽을 최대로 뚫은 것은 아닌 경우 nb = cb + 1로 하고 넘어가야함
                    visited[nx][ny][cb + 1] = true;
                    q.add(new int[]{nx, ny, cb + 1, nt});
                }
                //해당 위치가 범위도 벗어나지 않고, 벽도 아닌 경우 이미 방문한 곳만 아니라면 넘어감
                else if(!visited[nx][ny][cb]){
                    visited[nx][ny][cb] = true;
                    q.add(new int[]{nx, ny, cb, nt});
                }

                //다음 위치가 도착지인 경우
                if(nx == x - 1 && ny == y - 1){
                    result = nt;
                    return;
                }
            }


        }
    }
}
