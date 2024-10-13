package bj.dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
/*
knapsack 문제
 */
public class BJ12865 {
    static int m;
    static int n;
    static int[][] bag;
    static int[][] knapsack;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        m = Integer.parseInt(st.nextToken());//입력받는 개수 4
        n = Integer.parseInt(st.nextToken());//한계 무게 7
        bag = new int[m+1][2]; //0에는 무게, 1에는 가치
        knapsack = new int[m+1][n+1];

        for (int i = 1; i <= m; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 2; j++) {
                bag[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        dp();

        System.out.println(knapsack[m][n]);
    }

    public static void dp(){
        for(int i = 1; i <= m; i++){//i는 몇번째냐 1~4
            for(int j = 1; j <= n; j++){//j가 무게
                int w = bag[i][0];
                if(j >= w){
                    knapsack[i][j] = Math.max(knapsack[i-1][j-w] + bag[i][1], knapsack[i-1][j]);
                }
                else{
                    knapsack[i][j] = knapsack[i-1][j];
                }
            }
        }
    }
}
