package bj.recursive;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ2630 {
    static int n, white, blue = 0;
    static int[][] map;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        map = new int[n][n];
        StringTokenizer st;
        for(int i = 0; i < n; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < n; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        rec(n, 0, 0);
        System.out.println(white);
        System.out.println(blue);
    }
    static void rec(int size, int sx, int sy){
        if(isMatch(size, sx, sy)){
            if(map[sx][sy] == 0){
                white++;
            }
            else{
                blue++;
            }
            return;
        }
        int s = size/2;
        rec(s, sx, sy);
        rec(s, sx + s, sy);
        rec(s, sx, sy + s);
        rec(s, sx + s, sy + s);

    }
    static boolean isMatch(int size, int sx, int sy){
        int tmp = map[sx][sy];
        for(int i = sx; i < sx + size; i++){
            for(int j = sy; j < sy + size; j++){
                if(map[i][j] != tmp){
                    return false;
                }
            }
        }
        return true;
    }
}
