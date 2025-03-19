package bj.bfs_dfs;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class BOJ10026 {
    static int lines;
    static char[][] rgb;
    static int result;
    static int resultBlind;
    static boolean[][] visited;
    static boolean[][] visitedBlind;

    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        //라인 값 받기 및 rgb 배열 생성
        lines = sc.nextInt();
        rgb = new char[lines][lines];
        visited = new boolean[lines][lines];
        visitedBlind = new boolean[lines][lines];
        result = 0;
        resultBlind = 0;


        //rgb 값 채우기
        for(int i = 0; i < lines; i++) {
            String chars = sc.next();
            for(int j = 0; j < lines; j++) {
                rgb[i][j] = chars.charAt(j);
            }
        }
        //순차적으로 탐색하면서 방문 여부에 따라 함수 실행
        for(int i = 0; i < lines; i++) {
            for(int j = 0; j < lines; j++) {
                if(!visited[i][j]) {
                    result++;
                    bfs(i, j, rgb[i][j]);
                }
                if(!visitedBlind[i][j]) {
                    resultBlind++;
                    bfsBlind(i, j, rgb[i][j]);
                }
            }
        }
        System.out.print(result + " ");
        System.out.print(resultBlind);
    }

    //같은 색인 것만 visit
    static void bfs(int x, int y, char color){
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{x, y});
        visited[x][y] = true;

        while(!queue.isEmpty()){
            int[] loc = queue.poll();

            for (int i = 0; i < 4; i++) {
                int nx = loc[0] + dx[i];
                int ny = loc[1] + dy[i];

                //범위를 벗어난 경우
                if(nx < 0 || nx >= lines || ny < 0 || ny >= lines) continue;

                //위치 값의 색상이 같으면서 방문하지 않은 경우
                if(rgb[nx][ny] == color && !visited[nx][ny]){
                    visited[nx][ny] = true;
                    queue.add(new int[]{nx, ny});
                }

            }
        }
    }

    //같은 색인 것만 visit하되, r과 g는 같은 색 취급
    static void bfsBlind(int x, int y, char color){
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{x, y});
        visitedBlind[x][y] = true;

        while(!queue.isEmpty()){
            int[] loc = queue.poll();
            for(int i = 0; i < 4; i++) {
                int nx = loc[0] + dx[i];
                int ny = loc[1] + dy[i];

                if(nx < 0 || nx >= lines || ny < 0 || ny >= lines) continue;

                //color가 G이거나 R일 때, rgb의 값도 G이거나 R인 경우
                // 괄호 유의
                if((color == 'G' || color == 'R') && (rgb[nx][ny] == 'G' || rgb[nx][ny] == 'R')){
                    if(!visitedBlind[nx][ny]){
                        visitedBlind[nx][ny] = true;
                        queue.add(new int[]{nx, ny});
                    }
                }
                //color가 B인 경우
                else{
                    if(rgb[nx][ny] == color && !visitedBlind[nx][ny]){
                        visitedBlind[nx][ny] = true;
                        queue.add(new int[]{nx, ny});
                    }
                }
            }
        }
    }
}
