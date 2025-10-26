package bj.implement;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ18808 {
    static int n, m, k;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        int[][] arr = new int[n][m];//스티커북
        int answer = 0;

        for (int i = 0; i < k; i++) {
            st = new StringTokenizer(br.readLine());
            int tx = Integer.parseInt(st.nextToken());
            int ty = Integer.parseInt(st.nextToken());
            int[][] sticker = new int[tx][ty];
            for (int j = 0; j < tx; j++) {
                st = new StringTokenizer(br.readLine());
                for(int l = 0; l < ty; l++) {
                    sticker[j][l] = Integer.parseInt(st.nextToken());
                }
            }//개별 스티커 여기서 각각 읽어놓은 상태 여기서부터 스티커 붙이기 시작해야함
            sticker(arr, sticker);
        }//스티커 다 붙인 상태, 빈 행, 열이 없는지 탐색해야함
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                if(arr[i][j] == 1) {
                    answer += 1;
                }
            }
        }
        System.out.println(answer);
    }

    public static void sticker(int[][]tmp, int[][]sticker){
        for(int i = 0; i < 4; i++){
            int[][] tSticker;
            if(i == 0){
                //스티커 그대로
                if(rounding(tmp, sticker)){
                    break;
                }
            }
            else if(i == 3){
                tSticker = new int[sticker[0].length][sticker.length];
                int ty = 0;
                for(int j = 0; j < sticker.length; j++, ty++){
                    int tx = 0;
                    for(int k = sticker[0].length - 1; k >= 0; k--, tx++){
                        tSticker[tx][ty] = sticker[j][k];
                    }
                }
                if(rounding(tmp, tSticker)){
                    break;
                }
            }
            else if(i == 2){
                tSticker = new int[sticker.length][sticker[0].length];
                int tx = 0;
                for(int j = sticker.length - 1; j >= 0; j--, tx++){
                    int ty = 0;
                    for(int k = sticker[0].length - 1; k >= 0; k--, ty++){
                        tSticker[tx][ty] = sticker[j][k];
                    }
                }
                if(rounding(tmp, tSticker)){
                    break;
                }
            }
            else{
                tSticker = new int[sticker[0].length][sticker.length];
                int ty = 0;
                for(int j = sticker.length - 1; j >= 0; j--, ty++){
                    int tx = 0;
                    for(int k = 0; k < sticker[0].length; k++, tx++){
                        tSticker[tx][ty] = sticker[j][k];
                    }
                }
                if(rounding(tmp, tSticker)){
                    break;
                }
            }
        }
    }
    //좌표를 돌면서 붙일 수 있는지 조회
    public static boolean rounding(int[][]tmp, int[][]sticker){
        if(tmp.length < sticker.length || tmp[0].length < sticker[0].length){
            return false;
        }
        for(int i = 0; i < tmp.length - sticker.length + 1; i++){
            for(int j = 0; j < tmp[0].length - sticker[0].length + 1; j++){
                if(isMatch(tmp, sticker, i, j)){
                    return true;
                }
            }
        }
        return false;
    }

    public static boolean isMatch(int[][]tmp, int[][]sticker, int x, int y){
        for(int i = x; i < x+sticker.length; i++){
            for(int j = y; j < y+sticker[0].length; j++){
                if(tmp[i][j] == 1 && sticker[i - x][j - y] == 1){
                    return false;
                }
            }
        }
        for(int i = x; i < x+sticker.length; i++){
            for(int j = y; j < y+sticker[0].length; j++){
                if(tmp[i][j] == 0){
                    tmp[i][j] = sticker[i - x][j - y];
                }
            }
        }
        return true;
    }
}
