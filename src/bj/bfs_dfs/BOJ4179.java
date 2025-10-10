package bj.bfs_dfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ4179 {
    static int n;
    static int m;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static char [][] arr;
    static int [][] fire;
    static int [][] jihun;
    static boolean[][] fireVisit;
    static boolean[][] jihunVisit;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());//행
        m = Integer.parseInt(st.nextToken());//열

        arr = new char[n][m];
        fire = new int[n][m];
        fireVisit = new boolean[n][m];
        jihun = new int[n][m];
        jihunVisit = new boolean[n][m];

        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                fire[i][j] = Integer.MAX_VALUE;
                jihun[i][j] = Integer.MAX_VALUE;
            }
        }

        for (int i = 0; i < n; i++) {
            String[] str = br.readLine().split("");
            for (int j = 0; j < m; j++) {
                arr[i][j] = str[j].toCharArray()[0];
            }
        }
        //불은 여러개가 가능하므로 한번에 퍼지게 하기 위해서는 하나의 큐에 모아서 실행해야한다.
        fireBfs();

        outer: for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if(arr[i][j] == 'J') {
                    jihunBfs(i,j);
                    break outer;
                }
            }
        }

        int res = Integer.MAX_VALUE;
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                if(i == 0 || i == n-1 || j == 0 || j == m-1) {
                    res = Math.min(res, jihun[i][j]);
                }
            }
        }

        String result = (res != Integer.MAX_VALUE) ? String.valueOf(res + 1) : "IMPOSSIBLE";
        System.out.println(result);

        //생각할 것은 불을 먼저 돌리고 그 값을 넣고 그 이후에 지훈이를 돌리면서 불보다 먼저 도착했으면 값 변경하고 그거 아니면 방문할 수 없는 곳임을 판단
        //그 이후에 마지막까지 가면 해당 값 저장. 그리고 마지막으로 테두리 돌려서 값 파악

    }
    //여러번 가능한가보다..
    static void fireBfs(){
        Queue<int[]> q = new LinkedList<>();
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                if(arr[i][j] == 'F') {
                    q.add(new int[]{i, j, 0});
                    fire[i][j] = 0;
                    fireVisit[i][j] = true;
                }
            }
        }
        int dist;
        while(!q.isEmpty()){
            int[] cur = q.poll();
            for(int k = 0; k < 4; k++){
                int nx = cur[0] + dx[k];
                int ny = cur[1] + dy[k];
                dist = cur[2];
                if(nx < 0 || ny < 0 || nx >= n || ny >= m || fireVisit[nx][ny] || arr[nx][ny] == '#') {//범위를 넘어갔거나 방문한 경우
                    continue;
                }
                q.add(new int[]{nx, ny, dist + 1});
                fireVisit[nx][ny] = true;
                fire[nx][ny] = Math.min(fire[nx][ny], dist + 1);
            }
        }
    }

    //한번만 가능
    static void jihunBfs(int i, int j){
        Queue<int[]> q = new LinkedList<>();
        //fire를 참조하여 값 설정한다.
        q.add(new int[]{i, j, 0});
        jihunVisit[i][j] = true;
        jihun[i][j] = 0;
        int dist;
        while(!q.isEmpty()){
            int[] cur = q.poll();
            dist = cur[2];
            for(int k = 0; k < 4; k++){
                int nx = cur[0] + dx[k];
                int ny = cur[1] + dy[k];
                if(nx < 0 || ny < 0 || nx >= n || ny >= m || arr[nx][ny] == '#' || jihunVisit[nx][ny] || dist + 1 >= fire[nx][ny]) {
                    continue;
                }
                q.add(new int[]{nx, ny, dist + 1});
                jihunVisit[nx][ny] = true;
                jihun[nx][ny] = Math.min(jihun[nx][ny], dist + 1);
            }
        }
    }
}
