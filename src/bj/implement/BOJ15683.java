package bj.implement;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class BOJ15683 {
    static ArrayList<int[]> list = new ArrayList<>();
    static int n, m;
    static int result;
    static int[][] arr;
    static int[][] tmp;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        arr = new int[n][m];
        tmp = new int[n][m];
        result = n * m;
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
                tmp[i][j] = arr[i][j];
                if(arr[i][j]!=0 && arr[i][j] != 6){
                    list.add(new int[]{i, j});
                }
            }
        }
        makeTempList(new int[list.size()], 0);

        System.out.println(result);
    }
    public static void makeTempList(int[]temp, int depth){
        if(depth == list.size()){
            int[][] tmp = new int[n][m];
            for(int i=0;i<n;i++){
                for(int j=0;j<m;j++){
                    tmp[i][j] = arr[i][j];
                }
            }
            for(int i = 0; i < temp.length; i++){//temp에 숫자 다 채웠으니 그 숫자에 맞게 그림그리도록 함
                draw(temp[i], list.get(i)[0], list.get(i)[1], 0, 0, tmp);
            }
            int res = 0;
            for(int i = 0; i < n; i++){
                for(int j = 0; j < m; j++){
                    if(tmp[i][j] == 0){
                        res++;
                    }
                }
            }
            result = Math.min(res, result);
            return;
        }
        for(int i = 0; i < 4; i++){
            temp[depth] = i;
            makeTempList(temp, depth + 1);
        }
    }
    public static void draw(int way, int x, int y, int xDir, int yDir, int[][] tmp){
        if(x < 0 || x >= n || y < 0 || y >= m){//범위를 벗어난 경우
            return;
        }
        if(tmp[x][y] == 6){
            return;
        }
        if(xDir == 0 && yDir == 0){//방향성 없이 처음 도착한 위치일 때 방향성을 주면서 재귀를 진행한다.
            if(tmp[x][y] == 1){//cctv 넘버가 1인 경우
                if(way == 0){
                    draw(way,x + 1, y, 1, 0, tmp);
                }
                if(way == 1){
                    draw(way, x - 1, y, -1, 0, tmp);
                }
                if(way == 2){
                    draw(way, x, y + 1, 0, 1, tmp);
                }
                if(way == 3){
                    draw(way, x, y - 1, 0, -1, tmp);
                }
            }
            if(tmp[x][y] == 2){//cctv 넘버가 2인 경우
                if(way == 0 || way == 2){
                    draw(way, x, y + 1, 0, 1, tmp);
                    draw(way, x, y - 1, 0, -1, tmp);
                }
                if(way == 1 || way == 3){
                    draw(way, x + 1, y, 1, 0, tmp);
                    draw(way, x - 1, y, -1, 0, tmp);
                }
            }
            if(tmp[x][y] == 3){//cctv 넘버가 3인 경우
                if(way == 0){
                    draw(way, x + 1, y, 1, 0, tmp);
                    draw(way, x, y + 1, 0, 1, tmp);
                }
                if(way == 1){
                    draw(way, x - 1, y, -1, 0, tmp);
                    draw(way, x, y + 1, 0, 1, tmp);
                }
                if(way == 2){
                    draw(way, x + 1, y, 1, 0, tmp);
                    draw(way, x, y - 1, 0, -1, tmp);
                }
                if(way == 3){
                    draw(way, x - 1, y, -1, 0, tmp);
                    draw(way, x, y - 1, 0, -1, tmp);
                }
            }
            if(tmp[x][y] == 4){//cctv 넘버가 4인 경우
                if(way == 0){
                    draw(way, x + 1, y, 1, 0, tmp);
                    draw(way, x, y + 1, 0, 1, tmp);
                    draw(way, x, y - 1, 0, -1, tmp);
                }
                if(way == 1){
                    draw(way, x - 1, y, -1, 0, tmp);
                    draw(way, x, y + 1, 0, 1, tmp);
                    draw(way, x, y - 1, 0, -1, tmp);
                }
                if(way == 2){
                    draw(way, x + 1, y, 1, 0, tmp);
                    draw(way, x - 1, y, -1, 0, tmp);
                    draw(way, x, y + 1, 0, 1, tmp);
                }
                if(way == 3){
                    draw(way, x + 1, y, 1, 0, tmp);
                    draw(way, x, y - 1, 0, -1, tmp);
                    draw(way, x - 1, y, -1, 0, tmp);
                }
            }
            if(tmp[x][y] == 5){//cctv 넘버가 5인 경우
                draw(way, x + 1, y, 1, 0, tmp);
                draw(way, x - 1, y, -1, 0, tmp);
                draw(way, x, y + 1, 0, 1, tmp);
                draw(way, x, y - 1, 0, -1, tmp);
            }
        }
        else{//처음 도착한 것이 아니라서 방향성이 존재하는 경우
            if(tmp[x][y] == 0){
                tmp[x][y] = 7;
            }
            draw(way, x + xDir, y + yDir, xDir, yDir, tmp);
        }

    }
}
