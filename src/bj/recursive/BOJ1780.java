package bj.recursive;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ1780 {
    static int m1, p1, z, n = 0;
    static int[][] map;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        n = Integer.parseInt(br.readLine());
        map = new int[n][n];
        for(int i = 0; i < n; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < n; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        rec(n, 0, 0);

        System.out.println(m1);
        System.out.println(z);
        System.out.println(p1);

    } //main
    //for문 돌면서 n만큼 크기 돌리면서 하나로 통합이면 되는거고 아니면 9개로 자른다.
    //9개로 자르는게 n/3으로 size 넘기고 sx, sy 넘기는게 맞다.
    static void rec(int size, int sx, int sy){

        if(isMatch(size, sx, sy)){
            if(map[sx][sy] == -1){
                m1++;
            }
            else if(map[sx][sy] == 0){
                z++;
            }
            else{
                p1++;
            }
            return;
        }

        //9개로 나눠야한다.
        int ns = size/3;
        rec(ns, sx, sy);
        rec(ns, sx + ns, sy);
        rec(ns, sx + 2 * ns, sy);
        rec(ns, sx, sy + ns);
        rec(ns, sx, sy + 2 * ns);
        rec(ns, sx + ns, sy + ns);
        rec(ns, sx + ns, sy + 2 * ns);
        rec(ns, sx + 2 * ns, sy + ns);
        rec(ns, sx + 2 * ns, sy + 2 * ns);
    }
    static boolean isMatch(int size, int sx, int sy){
        int num = map[sx][sy];
        for(int i = sx; i < sx + size; i++){
            for(int j = sy; j < sy + size; j++){
                if(map[i][j] != num){
                    return false;
                }
            }
        }
        return true;
    }
}
