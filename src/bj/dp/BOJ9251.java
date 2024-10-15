package bj.dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
LCS 문제
 */
public class BOJ9251 {
    static int[][] lcs;
    static char[] first;
    static char[] second;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        first = br.readLine().toCharArray();
        second = br.readLine().toCharArray();
        lcs = new int[first.length+ 1][second.length + 1];
        for (int i = 1; i <= first.length; i++) {
            for (int j = 1; j <= second.length; j++) {
                if(first[i-1] == second[j-1]){
                    lcs[i][j] = lcs[i-1][j-1]+ 1;
                    // i-1, j-1인 이유는 그래야 [i][j]번 째 들어가는 요소가 개입이 안되기 때문
                }
                else{
                    lcs[i][j] = Math.max(lcs[i-1][j], lcs[i][j-1]);
                }
            }
        }
        System.out.println(lcs[first.length][second.length]);
    }
}
