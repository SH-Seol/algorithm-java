package bj.bfs_dfs;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ11967 {
    static int n,m;
    static ArrayList<int[]>[] lists;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        int result = Integer.MIN_VALUE;


        lists = new ArrayList[n * n];

        for(int i = 0; i < n * n; i++){
            lists[i] = new ArrayList<>();
        }

        //갈 수 있는 여부 체크 역방향은 안됨
        for(int i = 0; i < m; i++){
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            // n * (x - 1) + (y - 1)
            int start = n * (x - 1) + (y - 1);
            lists[start].add(new int[]{a - 1, b - 1});
        }

        System.out.println(bfs());
    }
    // 시작지점은 0,0
    //불이 켜져있고, isVisited가 false이면 갈 수 있음
    //불이 꺼져있거나 isVisited가 true면 갈 이유가 없음.
    //2, 1 을 가야하는데 이거 지금 그게 안된다. 그럼 각
    static int bfs(){
        int[] dx = {-1, 1, 0, 0};
        int[] dy = {0, 0, -1, 1};
        boolean[][] isLighted = new boolean[n][n];
        boolean[][] isVisited = new boolean[n][n];
        int res = 1;

        isLighted[0][0] = true;
        isVisited[0][0] = true;

        Queue<int[]> q = new ArrayDeque<>();
        q.add(new int[]{0, 0});


        //불을 키면서 인접 위치에 visited한 경험이 있는지 확인해야한다.
        //그리고 방문하면서 또한 인접 위치에 방문하지 않은 lighted가 있는지 확인해야한다.
        while(!q.isEmpty()){
            int[] cur = q.poll();
            int cx = cur[0];
            int cy = cur[1];
            int cNum = n * cx + cy;
            int size = lists[cNum].size();
            //이건 불을 키는 것
            for(int i = 0; i < size; i++){
                int[] tmp = lists[cNum].get(i);
                int tx = tmp[0];
                int ty = tmp[1];
                if(!isLighted[tx][ty]){
                    isLighted[tx][ty] = true;
                    res++;
                    //4방 돌면서 인접 위치 visited 확인
                    for(int j = 0; j < 4; j++){
                        int nx = tx + dx[j];
                        int ny = ty + dy[j];

                        if(nx >= n || nx < 0 || ny >= n || ny < 0 || !isVisited[nx][ny]){
                            continue;
                        }
                        isVisited[tx][ty] = true;
                        q.add(new int[]{tx, ty});
                        break;

                    }
                }
            }

            //이건 넘어가는거고 넘어갈 때 nx, ny의 4방향이 isVisited가 true면
            for(int i = 0; i < 4; i++){
                int nx = cx + dx[i];
                int ny = cy + dy[i];

                if(nx >= n || nx < 0 || ny >= n || ny < 0 || !isLighted[nx][ny] || isVisited[nx][ny]){
                    continue;
                }
                //lists의 nx,ny에 해당하는 값에서 불을 킬 수 있는 곳이 있는지 확인해야지
                if(isLighted[nx][ny] && !isVisited[nx][ny]){
                    isVisited[nx][ny] = true;
                    q.add(new int[]{nx, ny});
                }

            }
        }
        return res;
    }
}
