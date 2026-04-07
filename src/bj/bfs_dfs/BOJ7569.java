package bj.bfs_dfs;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ7569 {
    static int[][][] tomatoes;
    static int answer;
    static Queue<int[]> q;

    static int[] dx = new int[]{-1, 1, 0, 0, 0, 0};
    static int[] dy = new int[]{0, 0, -1, 1, 0, 0};
    static int[] dz = new int[]{0, 0, 0, 0, -1, 1};

    static int x, y, z;

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()); // 5 3 2
        x = Integer.parseInt(st.nextToken());//5
        y = Integer.parseInt(st.nextToken());//3
        z = Integer.parseInt(st.nextToken());//2

        q = new LinkedList<>();

        answer = Integer.MIN_VALUE;//결과값 저장 위한 것

        tomatoes = new int[y][x][z];

        //큐에 익은 토마토의 위치를 넣음.
        for(int i = 0; i < z; i++){
            for(int j = 0; j < y; j++){
                st = new StringTokenizer(br.readLine());
                for(int k = 0; k < x; k++){
                    tomatoes[j][k][i] = Integer.parseInt(st.nextToken());
                    if(tomatoes[j][k][i] == 1){
                        q.add(new int[]{j, k, i});
                    }
                }
            }
        }

        bfs();

        search: for(int i = 0; i < z; i++){
            for(int j = 0; j < y; j++){
                for(int k = 0; k < x; k++){
                    if(tomatoes[j][k][i] == 0){
                        answer = -1;
                        break search;
                    }
                    answer = Math.max(answer, tomatoes[j][k][i] - 1);
                }
            }
        }

        System.out.println(answer);
    }

    public static void bfs(){
        while(!q.isEmpty()){
            int[] cur = q.poll();

            int curX = cur[1];
            int curY = cur[0];
            int curZ = cur[2];

            for(int i = 0; i < 6; i++){
                //다음 위치 세팅
                int nx = curX + dx[i];
                int ny = curY + dy[i];
                int nz = curZ + dz[i];

                //다음 위치가 범위 넘어갔는지 판단
                if(nx >= x || nx < 0 || ny >= y || ny < 0 || nz >= z || nz < 0){
                    continue;
                }

                //방문하지 않은 안 익은 토마토인 경우 직전 위치에서 + 1
                if(tomatoes[ny][nx][nz] == 0){
                    tomatoes[ny][nx][nz] = tomatoes[curY][curX][curZ] + 1;
                    q.add(new int[]{ny, nx, nz});
                }
            }
        }
    }
}
