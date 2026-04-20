package bj.bt;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class BOJ1799 {
    static int n;
    static int[] visitedP;
    static int[] visitedM;
    static int[][] map;
    static boolean[][] visited;
    static int result = Integer.MIN_VALUE;
    //1인 값, 말을 놓을 수 있는 곳
    static List<int[]> ableEven = new ArrayList<>();
    static List<int[]> ableOdd = new ArrayList<>();

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        n = Integer.parseInt(br.readLine());

        int res = 0;

        visitedP = new int[n * 2 - 1];
        visitedM = new int[n * 2 - 1];

        map = new int[n][n];
        visited = new boolean[n][n];

        for(int i = 0; i < n; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < n; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
                if(map[i][j] == 1){
                    if((i + j) % 2 == 0){
                        ableEven.add(new int[]{i, j});
                    }
                    else{
                        ableOdd.add(new int[]{i, j});
                    }
                }
            }
        }
        bt(0,0, ableEven);
        res += result;
        result = Integer.MIN_VALUE;
        bt(0,0, ableOdd);
        res += result;
        System.out.println(res);
    }
    //놓을 수 있으면 놓고
    static void bt(int idx, int cnt, List<int[]> able){
        if(idx >= able.size()){
            result = Math.max(result, cnt);
            return;
        }
        int[] spot = able.get(idx);
        int vm = spot[0] - spot[1] + n - 1;
        int vp = spot[0] + spot[1];
        //놓을 수 있는 경우
        if(visitedM[vm] == 0 && visitedP[vp] == 0){
            visitedM[vm]++;
            visitedP[vp]++;
            bt(idx + 1, cnt + 1, able);
            visitedM[vm]--;
            visitedP[vp]--;
        }
        bt(idx + 1, cnt, able);

    }
}
