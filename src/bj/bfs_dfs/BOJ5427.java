package bj.bfs_dfs;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ5427 {
    static int x;
    static int y;
    static char[][] chars;
    static int[][] map;
    static Queue<int[]> fire;
    static Queue<int[]> human;
    static StringBuilder sb = new StringBuilder();

    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int cases = Integer.parseInt(br.readLine());

        for(int i = 0; i < cases; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            y = Integer.parseInt(st.nextToken()); // 4
            x = Integer.parseInt(st.nextToken()); // 3

            fire = new LinkedList<>();
            human = new LinkedList<>();
            // 값 채우기
            chars = new char[x][y];
            map = new int[x][y];
            for(int j = 0; j < x; j++){
                String s = br.readLine();
                for(int k = 0; k < y; k++){
                    chars[j][k] = s.charAt(k);
                    //불의 좌표 넣기
                    if(chars[j][k] == '*'){
                        fire.add(new int[]{j, k, 0});
                    }
                    //사람 좌표 넣기
                    if(chars[j][k] == '@'){
                        human.add(new int[]{j, k, 0});
                    }
                } // for k
            } // for j
            bfs();
        } //for i
        System.out.println(sb.toString());
    }

    public static void bfs(){
        //불이 먼저 번져나가면서 chars는 변경하지 않고 map에 시간만 기록한다? 그러려면 visited가 필요하다 그리고 여기는 시간을 기록하는게 맞다
        int[][] fireVisited = new int[chars.length][chars[0].length];
        boolean[][] humanVisited = new boolean[chars.length][chars[0].length];
        int result = Integer.MAX_VALUE;
        while(!fire.isEmpty()){
            int[] f = fire.poll();
            int cx = f[0];
            int cy = f[1];
            int ct = f[2];

            for(int i = 0; i < 4; i++){
                int nx = cx + dx[i];
                int ny = cy + dy[i];
                int nt = ct + 1;
                //범위 넘어가거나 이미 방문했거나
                if(nx >= x || nx < 0 || ny >= y || ny < 0 ||
                chars[nx][ny] =='#' || chars[nx][ny] == '*' || fireVisited[nx][ny] != 0){
                    continue;
                }
                else{
                    fireVisited[nx][ny] = nt;
                    fire.add(new int[]{nx, ny, nt});
                }
            }
        }//while fire
        human: while(!human.isEmpty()){
            int[] h = human.poll();
            int cx = h[0];
            int cy = h[1];
            int ct = h[2];

            for(int i = 0; i < 4; i++){
                int nx = cx + dx[i];
                int ny = cy + dy[i];
                int nt = ct + 1;
                //범위를 넘어간 경우 끝
                if(nx == x || nx < 0 || ny == y || ny < 0){
                    result = nt;
                    break human;
                }
                //길이 아니면 어차피 못 감, 이미 방문한 경우 넘어감
                if(chars[nx][ny] != '.' || humanVisited[nx][ny]){
                    continue;
                }
                //길인 경우 불이 거기 언제 도착했는지와 nt를 비교하고 nt가 더 작으면 human에 추가, 더 크거나 같으면 넘어가야함
                if(fireVisited[nx][ny] > nt || (chars[nx][ny] != '*' && fireVisited[nx][ny] == 0)){
                    humanVisited[nx][ny] = true;
                    human.add(new int[]{nx, ny, nt});
                }
            }
        }
        if(result != Integer.MAX_VALUE){
            sb.append(result).append("\n");
        }
        else{
            sb.append("IMPOSSIBLE\n");
        }

    }
}
