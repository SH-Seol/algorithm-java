package bj.bfs_dfs;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class BOJ2178 {
    static int[][] map;
    static boolean[][] visited;
    static int m;
    static int n;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        m = sc.nextInt();
        n = sc.nextInt();

        map = new int[m][n];
        visited = new boolean[m][n];

        //값 넣기
        for(int i = 0;i<m;i++){
            String input = sc.next();
            for(int j = 0;j<n;j++){
                map[i][j]= input.charAt(j) -'0';
            }
        }

        //결과값 출력
        bfs(0,0);
    }

    static void bfs(int x, int y){
        int tx;
        int ty;
        int dist;
        int[] dx = {-1,1,0,0};
        int[] dy = {0,0,-1,1};
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{x, y, 1});
        visited[x][y] = true;
        while(!queue.isEmpty()){
            int[] poll = queue.poll();
            //종점 도착한 경우 출력
            if(poll[0]==m-1 && poll[1]==n-1){
                System.out.println(poll[2]);
                break;
            }
            //종점에 도달하지 않은 경우
            for(int i = 0;i<4;i++){
                tx = poll[0] + dx[i];
                ty = poll[1] + dy[i];
                dist = poll[2];
                //길이 있고, 도달한 적 없고, 그리고 범위 내에 있는 경우
                if(tx>=0 && tx<m && ty>=0 && ty<n && !visited[tx][ty] && map[tx][ty]==1){
                    queue.add(new int[]{tx,ty,dist+1});
                    visited[tx][ty] = true;
                }
            }
        }
    }
}
