package bj.bf;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ14889 {
    static int n;
    static int[][] map;
    static int result = Integer.MAX_VALUE;
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
        //그룹 n/2로 나눠서 정하고
        int[] team1 = new int[n/2];
        team1[0] = 0;

        grouping(1, 1, team1);

        System.out.println(result);

    }
    //그룹 나누기
    static void grouping(int depth, int start, int[] team1){
        if(depth == n/2){
            //숫자 돌면서
            int[] team2 = new int[n/2];
            int idx = 0;
            boolean[] check = new boolean[n];

            for(int i = 0; i < n/2; i++){
                check[team1[i]] = true;
            }

            for(int i = 0; i < n; i++){
                if(!check[i]){
                    team2[idx++] = i;
                }
            }
            calc(team1, team2);
            return;
        }
        for(int i = start; i < n; i++){
            //넣고 넘기는 것
            team1[depth] = i;
            grouping(depth + 1, i + 1, team1);
        }
    }

    //계산하고
    //계산 과정이 생각해보니까 1,2,3 이면 12 21 13 31 23 32 이렇게 다 더하는거였네 개 귀찮네;
    static void calc(int[] team1, int[] team2){
        int t1 = 0;
        int t2 = 0;
        //i는 team의 1 j는 팀의 2, 3을 나타내야함
        for(int i = 0; i < n/2 - 1; i++){
            int f1 = team1[i];
            int f2 = team2[i];
            for(int j = i + 1; j < n/2; j++){
                int e1 = team1[j];
                int e2 = team2[j];
                t1 += map[f1][e1] + map[e1][f1];
                t2 += map[f2][e2] + map[e2][f2];
            }
        }
        result = Math.min(result, Math.abs(t1 - t2));
    }
}
