package bj.bf;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ14501 {
    static int[][] treat;
    static int n;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        n = Integer.parseInt(br.readLine());
        treat = new int[n][2];//0은 일수, 1은 금액
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            treat[i][0] = Integer.parseInt(st.nextToken());
            treat[i][1] = Integer.parseInt(st.nextToken());
        }
        System.out.println(solution(0));
    }

    public static int solution(int day){//day는 일자
        if(day >= n){//넘어가는거
            return 0;
        }
        int withoutWork = solution(day+1);
        int withWork = 0;
        if(day + treat[day][0] <= n){
            withWork = solution(day+treat[day][0]) + treat[day][1];
        }

        return Math.max(withoutWork, withWork);
    }
}
