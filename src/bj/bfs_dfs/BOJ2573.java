package bj.bfs_dfs;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ2573 {
    static int x, y;
    static Queue<int[]> q = new ArrayDeque<>();
    static boolean[][] visited;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, 1, -1};
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        x = Integer.parseInt(st.nextToken());
        y = Integer.parseInt(st.nextToken());
        int[][] map = new int[x][y];
        visited = new boolean[x][y];

        //map 채우기
        for(int i = 0; i < x; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < y; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
                if(map[i][j] != 0){
                    q.add(new int[]{i, j});
                }
            }
        }
        //처음부터 2덩어리 이상이면 0출력하고 넘김
        if(islands(map) >= 2){
            System.out.println(0);
            return;
        }

        System.out.println(bfs(map));
    }

    /**
     * 일단 당장 q에 있는 것들은 섬임 당연히 넘겨 받아야하는 것도 지도고 넘겨줘야하는 것도 지도임
     */
    static int bfs(int[][] map){
        int day = 1;
        //처음 q돌릴 때 크기만큼 돌려야 시간 파악이 된다.
        while(true){
            //먼저 섬 개수부터 판단함.
            visited = new boolean[x][y];

            int[][] tmp = new int[x][y];
            int size = q.size();
            if(size == 0){
                break;
            }
            //q에 해달 일자에 있는 빙산만 돌린다.
            for(int i = 0; i < size; i++){
                int[] cur = q.poll();
                int cx = cur[0];
                int cy = cur[1];
                int m = 0;
                //사방을 돌면서 범위 내인지, 혹은 내륙인지 판단한다.
                for(int j = 0; j < 4; j++){
                    int nx = cx + dx[j];
                    int ny = cy + dy[j];
                    //범위 벗어나거나 내륙이면 넘어간다
                    if(nx >= x || nx < 0 || ny >= y || ny < 0 || map[nx][ny] != 0){
                        continue;
                    }
                    //해당 위치가 물이라면 다 더한 후 tmp에 값에 map에서 뺀 값을 저장함
                    m++;
                }
                tmp[cx][cy] = map[cx][cy] > m ? map[cx][cy] - m: 0;
                //다 돈 후에 tmp[x][y] 가 0이 아니면 q에 저장
                if(tmp[cx][cy] != 0){
                    q.add(new int[]{cx,cy});
                }
            }
            for(int i = 0; i < x; i++){
                for(int j = 0; j < y; j++){
                    map[i][j] = tmp[i][j];
                }
            }
            int island = islands(map);
            if(island == 0){
                return 0;
            }
            else if(island >= 2){
                return day;
            }
            day++;
        }
        return day;
    }

    /**
     * 섬의 개수가 2개 이상인지 확인하는 것 당연히 시작부터 이걸 돌면서 섬 개수 확인하는게 맞겠지
     * @return
     */
    static int islands(int[][] map){
        int size = 0;
        //지도를 받고 지도를 돌면서 땅을 찾으면 거기서부터 돌면서 내륙은 전부 위치 0 처리(visited대신 메모리 아낄겸)하면서 q에 넣는거임
        for(int i = 0; i < map.length; i++){
            for(int j = 0; j < map[i].length; j++){
                //물가도 아니고 방문하지 않았다면
                if(map[i][j] != 0 && !visited[i][j]){
                    visited[i][j] = true;
                    match(i, j, map);
                    size++;
                }
            }
        }

        return size;
    }

    static void match(int n, int m, int[][]map){
        Queue<int[]> lq = new ArrayDeque<>();
        lq.add(new int[]{n,m});
        while(!lq.isEmpty()){
            int[] tmp = lq.poll();
            int cx = tmp[0];
            int cy = tmp[1];
            for(int i = 0; i < 4; i++){
                int nx = cx + dx[i];
                int ny = cy + dy[i];

                if(nx >= x || nx < 0 || ny >= y || ny < 0 || visited[nx][ny] || map[nx][ny] == 0){
                    continue;
                }
                visited[nx][ny] = true;
                lq.add(new int[]{nx, ny});
            }
        }
    }
}
