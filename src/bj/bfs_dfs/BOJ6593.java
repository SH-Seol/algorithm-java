package bj.bfs_dfs;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ6593 {

    static int[] dx = {-1,1,0,0,0,0};
    static int[] dy = {0,0,-1,1,0,0};
    static int[] dz = {0,0,0,0,-1,1};

    static Queue<int[]> q;
    static StringBuilder sb = new StringBuilder();

    static int l, r, c;

    static char[][][] map;
    static boolean[][][] visited;

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        while(true){
            st = new StringTokenizer(br.readLine());
            l = Integer.parseInt(st.nextToken());
            r = Integer.parseInt(st.nextToken());
            c = Integer.parseInt(st.nextToken());

            if(l == 0 && r == 0 && c == 0){
                break;
            }

            map = new char[r][c][l];
            visited = new boolean[r][c][l];

            q = new ArrayDeque<>();

            for(int i = 0; i < l; i++){
                for(int j = 0; j < r; j++){
                    String s = br.readLine();
                    for(int k = 0; k < c; k++){
                        map[j][k][i] = s.charAt(k);
                        if(map[j][k][i] == 'S'){
                            q.add(new int[]{j,k,i,0});
                            visited[j][k][i] = true;
                        }
                    }
                }
                String s = br.readLine();//공백 줄 소거
            }
            bfs();
        }

        System.out.println(sb.toString());
    }

    static void bfs(){
        boolean found = false;
        cycle: while(!q.isEmpty()){
            int[] tmp = q.poll();
            int cx = tmp[0];
            int cy = tmp[1];
            int cz = tmp[2];
            int ct = tmp[3];

            for(int i = 0; i < 6; i++){
                int nx = cx + dx[i];
                int ny = cy + dy[i];
                int nz = cz + dz[i];
                int nt = ct + 1;

                //범위 체크
                if(nx < 0 || nx >= r || ny < 0 || ny >= c || nz < 0 || nz >= l ||
                map[nx][ny][nz] == '#' || visited[nx][ny][nz]) {
                    continue;
                }

                // E 발견했으면 끝냄
                if(map[nx][ny][nz] == 'E'){
                    sb.append("Escaped in ").append(nt).append(" minute(s).\n");
                    found = true;
                    break cycle;
                }

                // 벽도 아니고 E도 아니면 넘어감
                visited[nx][ny][nz] = true;
                q.add(new int[]{nx, ny, nz, nt});

            } //for
        } //while

        if(!found){
            sb.append("Trapped!\n");
        }
    }
}
