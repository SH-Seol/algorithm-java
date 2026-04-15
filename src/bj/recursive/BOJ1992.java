package bj.recursive;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BOJ1992 {
    static int n;
    static int[][] map;
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        map = new int[n][n];
        for(int i = 0; i < n; i++){
            String s = br.readLine();
            for(int j = 0; j < n; j++){
                map[i][j] = Character.getNumericValue(s.charAt(j));
            }
        }

        rec(n, 0, 0);
        System.out.println(sb);
    }
    //매칭이 안되면 (를 추가해야한다. 또 안되면 (를 추가해야한다. 그리고 해당 재귀가 끝나면 )를 넣어줘야한다.
    //근데 나눠서 넣어줘야할 때만 (와 )를 넣는 것일 뿐, 나눠서 넣어줄 필요가 없다면 그냥 숫자만 넣는다.
    static void rec(int tn, int sx, int sy){
        //매칭이 된다 그냥 숫자만 추가
        if(isMatch(tn, sx, sy)){
            sb.append(map[sx][sy]);
        }
        //매칭이 안된다면 (를 추가하고 세분화해서 넣어주고 마지막에 )로 닫아줌
        else{
            sb.append('(');

            rec(tn/2, sx, sy);
            rec(tn/2, sx, sy + tn/2);
            rec(tn/2, sx + tn/2, sy);
            rec(tn/2, sx + tn/2, sy + tn/2);

            sb.append(')');
        }

    }
    static boolean isMatch(int tn, int sx, int sy){
        int num = map[sx][sy];
        for(int i = sx; i < tn + sx; i++){
            for(int j = sy; j < tn + sy; j++){
                if(map[i][j] != num){
                    return false;
                }
            }
        }
        return true;
    }
}
