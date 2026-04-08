package bj.bfs_dfs;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ2206 {
    static int[][] map;
    static int x;
    static int y;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static int result = -1;
    static boolean[][][] visited;
    static Queue<int[]> q = new ArrayDeque<>();
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        x = Integer.parseInt(st.nextToken());
        y = Integer.parseInt(st.nextToken());

        map = new int[x][y];

        for(int i = 0; i < x; i++){
            String s = br.readLine();
            for(int j = 0; j < y; j++){
                map[i][j] = s.charAt(j) - '0';
            }
        }
        q.add(new int[]{0,0,1,0});//x, y, distance, break?
        visited = new boolean[x][y][2];
        visited[0][0][0] = true;
        bfs();

        System.out.println(result);
    }
    //뒤로만 안가면 되잖아 그리고 tmp[3] = 0,1에 따라 1을 만났을 때 갈 수 있냐, 없냐가 정해진다. 그렇다면 각각의 경우에 visited는 변하므로
    //visited를 넘겨주는 것이 더 좋아보인다.
    public static void bfs(){
        // 어차피 0, 0 시작
        // x-1, y-1 도착하면 끝 거기까지 가기 위한 그 길이를 판별하면 됨
        //
        while(!q.isEmpty()){
            int[] tmp = q.poll();

            int cx = tmp[0];
            int cy = tmp[1];
            int cd = tmp[2];
            int cb = tmp[3];//0이면 벽 아직 안 부순 거고, 1이면 이미 벽을 부순 것

            if(cx == x - 1 && cy == y - 1){
                result = cd;
                break;
            }

            for(int i = 0; i < 4; i++){
                int nx = cx + dx[i];
                int ny = cy + dy[i];
                int nd = cd + 1;

                //범위를 벗어난 경우 혹은 이미 왔던 길인 경우
                if(nx >= x || nx < 0 || ny >= y || ny < 0 || visited[nx][ny][cb]){
                    continue;
                }
                //다음 위치가 벽인 경우
                if(map[nx][ny] == 1){
                    //이미 한번 벽을 뚫었다면 넘어간다
                    if(cb == 1){
                        continue;
                    }
                    //벽을 뚫어볼 수 있다면 뚫고 가본다.
                    visited[nx][ny][1] = true;
                    q.add(new int[]{nx, ny, nd, 1});
                }
                //다음 위치가 그냥 길인 경우
                else{
                    visited[nx][ny][cb] = true;
                    q.add(new int[]{nx, ny, nd, cb});
                }
            }
        }
    }
}
