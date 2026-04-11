package bj.bfs_dfs;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ16920 {
    static int n, m, p;
    static int[] s;
    static int[] res;
    static char[][] map;
    static Queue<int[]>[] qs;
    static boolean[][] visited;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        p = Integer.parseInt(st.nextToken());

        s = new int[p];
        res = new int[p];
        map = new char[n][m];
        qs = new Queue[p];
        visited = new boolean[n][m];

        st = new StringTokenizer(br.readLine());

        //step 길이 저장
        for(int i = 0; i < p; i++){
            s[i] = Integer.parseInt(st.nextToken());
            qs[i] = new ArrayDeque<>();
        }

        //map 저장
        for(int i = 0; i < n; i++){
            String tmp = br.readLine();
            for(int j = 0; j < m; j++){
                map[i][j] = tmp.charAt(j);
                if(map[i][j] != '.' && map[i][j] != '#'){
                    //숫자인 경우 x, y좌표를 저장하고 방문처리한다.
                    qs[Character.getNumericValue(map[i][j]) - 1].add(new int[]{i, j});
                    visited[i][j] = true;
                    res[Character.getNumericValue(map[i][j]) - 1]++;
                }
            }
        }

        //n 과 m 모두 1인 경우 맵에 있는 녀석만
        if(n == 1 && m == 1){
            res[Character.getNumericValue(map[0][0]) - 1] = 1;
            for(int i = 0; i < p; i++){
                sb.append(res[i]).append(" ");
            }
            System.out.println(sb);
            return;
        }

        bfs();

        //결과 출력
        for(int i = 0; i < p; i++){
            sb.append(res[i]).append(" ");
        }
        System.out.println(sb);
    }
    static void bfs(){
        int[] dx = {-1, 1, 0, 0};
        int[] dy = {0, 0, -1, 1};

        /**
         * 타임마다 계속 돌아야한다. 그리고 타임마다 얼만큼 돌아야하냐? 일단 s에 있는 만큼 그 길이만큼 퍼질 거다. 즉 s만큼 bfs돌리면 된다
         * 벽은 넘어갈 수 있다.
         */
        while(true){
            //니 차례 내 차례 순서대로 돌아가요 마지막도 다 하면 다시 처음으로 넘어가요. 근데 언제 다 끝나냐면 모두 갈 곳이 없으면 끝나요.
            boolean able = false;
            for(int i = 0; i < p; i++){
                int len = s[i];//s만큼 bfs 돌릴거에요
                for(int j = 0; j < len; j++){
                    int size = qs[i].size();//당장 지금 q에 담겨있는 대기 중인 배열들
                    if(size == 0){
                        break;
                    }
                    for(int k = 0; k < size; k++){//2개만 있었으면 더 추가되는건 빼지 않고 2개만 돌리는거임
                        int[] cur = qs[i].poll();
                        int cx = cur[0];
                        int cy = cur[1];
                        for(int l = 0; l < 4; l++) {
                            int nx = cx + dx[l];
                            int ny = cy + dy[l];
                            if(nx >= n || nx < 0 || ny >= m || ny < 0 || visited[nx][ny] || map[nx][ny] == '#'){
                             continue;
                            }
                            visited[nx][ny] = true;
                            qs[i].add(new int[]{nx, ny});
                            able = true;
                            res[i]++;
                        }
                    }
                }
            }//player별로 턴을 마친다
            //모든 플레이어가 움직이지 못했으면 탈출
            if(!able){
                break;
            }
        }
    }
}
